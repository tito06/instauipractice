package com.example.uipractice

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.uipractice.ui.theme.UiPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Add,
        BottomNavItem.Reels,
        BottomNavItem.Profile
    )


    var itemSelected by remember {
        mutableStateOf(items.first())
    }

    Scaffold(
    bottomBar = {
        NavigationBar(
            modifier = Modifier.height(60.dp),
            contentColor = Color.Black,
            containerColor = Color.White
        ) {
            items.forEach{ item ->
                NavigationBarItem(
                    icon = {
                        if(item == items.last()){

                            androidx.compose.material3.Icon(
                                painter = painterResource(id = item.icon) ,
                                contentDescription = item.title,
                                modifier = Modifier.height(30.dp)
                                    .width(30.dp)
                                    .clip(CircleShape))

                        }else{
                            androidx.compose.material3.Icon(
                                painter = painterResource(id = item.icon) ,
                                contentDescription = item.title,
                                modifier = Modifier.height(30.dp)
                                    .width(30.dp))

                        }

                        },
                    onClick = {},
                    selected = item == itemSelected,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    },
    content = {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(33.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Row {
                    Text(text = "Instagram",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(2.dp))

                    Icon(painter = painterResource(id = R.drawable.down_arrow),
                        contentDescription ="",
                        modifier = Modifier
                            .padding(4.dp, 8.dp)
                            .height(22.dp)
                            .width(22.dp))
                }

                Row {

                    Icon(painter = painterResource(id = R.drawable.heart_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .padding(6.dp, 4.dp)
                            .width(25.dp)
                            .height(25.dp))

                    Icon(painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(6.dp, 4.dp)
                            .width(25.dp)
                            .height(25.dp))

                }



            }


            Box(modifier = Modifier.height(5.dp))

            Story()

            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray))


            Body()
        }

    }
)

}


@Composable
fun Story(){


    val imageList = List(20){index ->

    painterResource(id = R.drawable.heart_icon)

    }

    LazyRow{
        items(20){index ->

            Column {

                if (index == 0){


                    Box {

                        Image(
                            painter = painterResource(id = R.drawable.dog_image),
                            contentDescription = "",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(8.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Blue, CircleShape)
                        )
                    }

                }else {

                    Image(
                        painter = painterResource(id = R.drawable.dog_image),
                        contentDescription = "",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(8.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Blue, CircleShape)
                    )

                }

                Text(text = "Dummy",
                    fontSize = 12.sp,
                modifier = Modifier.padding(12.dp,0.dp,0.dp,10.dp))
            }


            
        }


        }
    }


@Composable
fun Body(){

    LazyColumn(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){

        items(20){
            Column(modifier = Modifier
                .height(500.dp)
                .fillMaxWidth())
            {

                Image(
                    painter = painterResource(id = R.drawable.dog_image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Blue, CircleShape)
                )

                Text(text = "Dummy",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(12.dp,0.dp,0.dp,10.dp))

                Image(
                    painter = painterResource(id = R.drawable.dog_image),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .height(300.dp)
                        .fillMaxWidth()
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {

                    Row {


                        Icon(
                            painter = painterResource(id = R.drawable.heart_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(6.dp, 4.dp)
                                .width(25.dp)
                                .height(25.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.chat_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(6.dp, 4.dp)
                                .width(25.dp)
                                .height(25.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.share_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(6.dp, 4.dp)
                                .width(25.dp)
                                .height(25.dp)
                        )
                    }

                    Icon(painter = painterResource(id = R.drawable.save_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(6.dp, 4.dp)
                            .width(25.dp)
                            .height(25.dp))
                }
            }
        }

    }


}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UiPracticeTheme {
        Story()
    }
}