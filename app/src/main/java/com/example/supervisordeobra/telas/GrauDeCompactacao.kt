package com.example.supervisordeobra.telas

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.supervisordeobra.R
import androidx.compose.foundation.layout.Column as Column1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun grauDeCompactacao(navController:NavController, modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(color = Color(0xFF552A27))
                    .clip(RoundedCornerShape(20.dp))
                    ,
               verticalAlignment = Alignment.CenterVertically

            ) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)

                ) {
                    Text(
                        text = "ENSAIO", fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.size(2.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1.5f)

                ) {
                    Text(
                        text = "LABORATÓRIO", fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.size(2.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)

                ) {
                    Text(
                        text = "CAMPO", fontSize = 12.sp
                    )
                }
        }
            })
    {

    }
    }


////    data class NavItemState(
////        val title: String,
////        val selectedIcon: Image,
////        val unselectedIcon: Image,
////
////    )
////
////
////        val items = listOf(
////            NavItemState(
////                title = "ENSAIO",
////                selectedIcon = Image
////                unselectedIcon = Icons.Outlined.Home,
////
////            ),
////            NavItemState(
////                title = "Inbox",
////                selectedIcon = Icons.Filled.Email,
////                unselectedIcon = Icons.Outlined.Email,
////
////            ),
////            NavItemState(
////                title = "Account",
////                selectedIcon = Icons.Filled.Face,
////                unselectedIcon = Icons.Outlined.Face,
////
////        )
////        var bottomNavState by rememberSaveable {
////            mutableStateOf(0)
////        }
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Box(modifier.fillMaxWidth(),
//                            contentAlignment = Alignment.Center) {
//                            Text(text = "Top App Bar", fontWeight = FontWeight.Bold)
//                        }
//
//                    },
//                    modifier
//                        .padding(10.dp)
//                        .clip(RoundedCornerShape(20.dp)),
//                    navigationIcon = {
//                        IconButton(onClick = {  }) {
//                            Icon(painter = painterResource(id = R.drawable.laboratorio_background) , contentDescription = "Lavoratório")
//                        }
//
//                    },
//                    actions = {
//                        IconButton(onClick = {  }) {
//                            BadgedBox(badge = { Badge(
//                                modifier.size(10.dp)
//                            ) {
//                            }}) {
//                                Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Fav icon" )
//                            }
//
//                        }
//                        IconButton(onClick = {  }) {
//                            Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart icon" )
//                        }
//                    },
//                    colors = TopAppBarDefaults.smallTopAppBarColors(
//                        containerColor = Color(0xFFE0A9A5)
//                    )
//                )
//            },
//            bottomBar = {
//                NavigationBar(
//                    modifier
//                        .padding(10.dp)
//                        .clip(RoundedCornerShape(20.dp)),
//                    containerColor = Color(0xFFE0A9A5)
//                ) {
//                    items.forEachIndexed { index, item ->
//
//
//                        NavigationBarItem(
//
//                            selected = bottomNavState == index,
//                            onClick = { bottomNavState = index },
//                            icon = {
//                                BadgedBox(badge = {
//                                    if (item.hasBadge) Badge {}
//                                    if (item.messages != 0) Badge {
//                                        Text(text = "${item.messages}")
//                                    }
//                                }) {
//                                    Icon(
//                                        imageVector = if (bottomNavState == index) item.selectedIcon
//                                        else item.unselectedIcon,
//                                        contentDescription = item.title
//                                    )
//                                }
//
//                            },
//                            label = { Text(text = item.title) },
//                            colors = NavigationBarItemDefaults.colors(
//                                selectedIconColor = Color(0xFF552A27),
//                                selectedTextColor = Color(0xFF63332F),
//                                indicatorColor = Color(0xFFBB7E7A)
//                            )
//                        )
//                    }
//                }
//            },
//            floatingActionButton = {
//                FloatingActionButton(
//                    onClick = { },
//                    containerColor = Color(0xFFFF9800),
//                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp)
//                ) {
//                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
//                }
//            }
//        ) { contentPadding ->
//
//            Column(
//                modifier
//                    .padding(contentPadding)
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = items[bottomNavState].title, fontSize = 44.sp, fontWeight = FontWeight.Bold)
//            }
//        }





