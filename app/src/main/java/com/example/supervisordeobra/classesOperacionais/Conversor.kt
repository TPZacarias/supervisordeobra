package com.example.supervisordeobra.classesOperacionais

import android.content.Context
import android.util.Log

class Conversor(latitudeFinal: Double,longitudeFinal : Double) {
    val raioMaior = 6378137
    val raioMenor = 6356752.31425
    val achatamento = 0.003352811
    val k = 0.9996
    private var ys:Double = 0.0
    private var yn:Double = 0.0
    var valores: DoubleArray? = null
    var latitudeCoordenada = latitudeFinal
    var longitudeCoordenada = longitudeFinal
    fun converter( context: Context)

    {
        var primeiraExcentricidade = Math.sqrt ( achatamento * (2 - achatamento) )
        var primeiraExcentricidade2 = (2 * achatamento) - Math.pow ( achatamento, 2.0)
        var primeiraExcentricidade4 = Math.pow ( primeiraExcentricidade, 4.0)
        var primeiraExcentricidade6 = Math.pow ( primeiraExcentricidade, 6.0)
        var segundaExcentricidade = primeiraExcentricidade / Math.sqrt ( 1 - primeiraExcentricidade2 )
        var segundaExcentricidade2 = primeiraExcentricidade * primeiraExcentricidade / (1 - primeiraExcentricidade * primeiraExcentricidade)
        var senoDuasAngulo = Math.sin ( 2 * Math.toRadians ( latitudeCoordenada ) )
        var senoQuadroAngulo = Math.sin ( 4 * Math.toRadians ( latitudeCoordenada ) )
        var senoSeisAngulo = Math.sin ( 6 * Math.toRadians ( latitudeCoordenada ) )
        var senoAnguloSegunda = Math.pow ( Math.sin ( Math.toRadians ( latitudeCoordenada) ), 2.0)
        var m1 = Math.toRadians ( latitudeCoordenada ) * (1 - primeiraExcentricidade2 / 4 - 3 * primeiraExcentricidade4 / 64 - 5 * primeiraExcentricidade6 / 256)
        var m2 = senoDuasAngulo * (3 * primeiraExcentricidade2 / 8 + 3 * primeiraExcentricidade4 / 32 + 45 * primeiraExcentricidade6 / 1024)
        var m3 = senoQuadroAngulo * (15 * primeiraExcentricidade4 / 256 + 45 * primeiraExcentricidade6 / 1024)
        var m4 = senoSeisAngulo * (35 * primeiraExcentricidade6 / 3072)
        var m = (m1-m2+m3-m4)*raioMaior
        val m0 = 0
        val zona = (30+longitudeCoordenada/6).toInt()
        val fe = 500000
        val fn = 10000000
        var n = raioMaior / Math.sqrt ( 1 - primeiraExcentricidade2 * senoAnguloSegunda )
        var t = Math.pow ( Math.tan ( Math.toRadians ( latitudeCoordenada) ), 2.0)
        var c = segundaExcentricidade2 * Math.pow ( Math.cos ( Math.toRadians ( latitudeCoordenada) ), 2.0)
        var meridianocentral = (3 + (6 * zona )) - 180
        val a = Math.toRadians ( longitudeCoordenada - meridianocentral ) * Math.cos ( Math.toRadians ( latitudeCoordenada) )
        var y = k * (m - m0 + n * Math.tan ( Math.toRadians ( latitudeCoordenada) ) * ((Math.pow ( a, 2.0) / 2 + ((5 - t + 9 * c + 4 * Math.pow ( c,
            2.0)) * Math.pow ( a, 4.0)) / 24 + (61 - 58 * t + Math.pow ( t, 2.0) + 600 * c - 330 * segundaExcentricidade2) * Math.pow ( a,
            6.0) / 720)))
        var x = k * n * ((a + (1 - t + c) * Math.pow ( a, 3.0) / 6) + ((5 - 18 * t + Math.pow ( t,
            2.0) + 72 * c - 58 * segundaExcentricidade2) * Math.pow ( a, 5.0) / 120)) + fe


        if (y < 0) {
            ys = fn + y;

        } else {
            yn = y;

        }


        if (y < 0) {
            ys = fn + y;

        } else {
            yn = y;

        }
        Log.d("Coordenadas","$x + $ys" )
    }
}