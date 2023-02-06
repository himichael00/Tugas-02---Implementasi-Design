package com.fti.pam.pam_acitivty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fti.pam.pam_acitivty.ui.theme.*
import kotlin.text.Typography

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val quicksand = FontFamily(
            Font(R.font.nougat_extrablack, FontWeight.ExtraBold)
        )

        setContent {
            PAM_AcitivtyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val username = getIntent().getStringExtra("username") ?: ""
                    GreetingSection(username)
                }
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                            ),
                            BottomNavItem(
                                name = "History",
                                route = "history",
                                icon = Icons.Default.Search,
                                badgeCount = 23
                            ),
                            BottomNavItem(
                                name = "Notification",
                                route = "notification",
                                icon = Icons.Default.Notifications
                            ),
                            BottomNavItem(
                                name = "Profile",
                                route = "profile",
                                icon = Icons.Default.Person
                            ),
                        ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                )
                {
                    Navigation(navController = navController)
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            GreetingSection()
            MenuPilihan()
            greetlasttf()
            lasttransaction()
            greetquickaction()
            ChipsSection(chips = listOf("transfer VA", "transfer BA", "Flazz", "transfer BB"))
        }

    }
}

@Composable
fun GreetingSection(
    name: String = "Michael"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "BCA mobile",
                style = MaterialTheme.typography.h1
                )
            Text(text = "Selamat Datang, $name",
                style = MaterialTheme.typography.body1
            )
        }
    }

}

@Composable
fun HistoryScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "History screen")
    }
}

@Composable
fun NotificationScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Notification screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile screen")
    }
}

@Composable
fun MenuPilihan(
    color: Color = LightBlue
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 45.dp, vertical = 60.dp)
            .fillMaxWidth()
    ) {
        Column {
            Row (horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "Info",
                        modifier = Modifier.size(43.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_transfer),
                        contentDescription = "Transfer",
                        modifier = Modifier.size(38.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_payment),
                        contentDescription = "Payment",
                        modifier = Modifier.size(42.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_commerce),
                        contentDescription = "Commerce",
                        modifier = Modifier.size(46.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Row (horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cardless),
                        contentDescription = "Cardless",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_admin),
                        contentDescription = "Admin",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_flazz),
                        contentDescription = "Flazz",
                        modifier = Modifier.size(46.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonWhite)
                        .padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lifestyle),
                        contentDescription = "Lifestyle",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun greetlasttf() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 1.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Last Transaction",
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun lasttransaction(
    color: Color = LightGray
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 20.dp, vertical = 30.dp)
            .fillMaxWidth()
    ) {
        Column (verticalArrangement = Arrangement.Center)
        {
                Text(text = "Tony Stark",
                    style = MaterialTheme.typography.h6
                )
                Text(text = "Transfer Beetwen Account",
                    style = MaterialTheme.typography.body1,
                    color = LightBlue
                )
                Text(text = "Rp.300.000 +",
                    style = MaterialTheme.typography.body1,
                    color = Color.Green
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(LightBlue)
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_lasttransfer),
                contentDescription = "Lasttransfer",
                tint = Color.White,
                modifier = Modifier.size(46.dp)
            )
        }
    }
}

@Composable
fun greetquickaction() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 1.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Quick Action",
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun ChipsSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp, end = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) LightBlue
                        else KindGray
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = LightGray)
            }
        }
    }
}

    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen()
            }
            composable("history") {
                HistoryScreen()
            }
            composable("notification") {
                NotificationScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }

    @Composable
    fun BottomNavigationBar(
        items: List<BottomNavItem>,
        navController: NavHostController,
        modifier: Modifier = Modifier,
        onItemClick: (BottomNavItem) -> Unit
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        BottomNavigation(
            modifier = modifier,
            backgroundColor =  Color.White,
            elevation = 5.dp
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    selectedContentColor = LightBlue,
                    unselectedContentColor = Color.Gray,
                    onClick = { onItemClick(item) },
                    icon = {
                        Column(horizontalAlignment = CenterHorizontally) {
                            if (item.badgeCount > 0) {
                                BadgedBox(
                                    badge = {
                                        Text(text = item.badgeCount.toString())
                                    }
                                ) {
                                    Icon(imageVector = item.icon,
                                        contentDescription = item.name
                                    )
                                }
                            } else{
                                Icon(imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                            if (selected) {
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            }

                        }
                    }
                )
            }
        }
    }


}