package com.example.ucp1_20220140135_c

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Tampilan(
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Blue)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Box(
                modifier = Modifier.size(50.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.mamat ),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp).clip(CircleShape)
                )
                Icon(
                    Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (4).dp, y = (1).dp)
                )
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).align(Alignment.BottomEnd)
                        .offset(x = (300).dp, y = (-10).dp), tint = Color.White
                )
            }

            Column (
                modifier = Modifier.padding(start = 20.dp)
            ){
                Text(text = "Hallo,")
                Text(text = "Ahmad Nur", color = Color.White)
            }
        }

    }
    Text(text = "Masukkan Biodata Kamu")
    Text(text = "Masukkan Data Yang sebenarnya ")

}




@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier = Modifier
){



    var Email by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var Gender by remember { mutableStateOf("") }

    var dataGender = listOf("2020", "2021","2022")


    var ConfEmail by remember { mutableStateOf("") }
    var Confalamat by remember { mutableStateOf("") }
    var Confnotelepon by remember { mutableStateOf("") }
    var ConfGender by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.size(390.dp).background(Color.LightGray)
    ){
        Row (
            modifier = Modifier.size(300.dp).padding(100.dp)
        ){

        }
    }

            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Tampilan()



                TextField(
                    value = Email,
                    onValueChange = {Email = it},
                    label = {
                        Text(text = "Email")
                    },
                    placeholder = { Text(text = "Isi Email Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp).clip(RoundedCornerShape(30.dp)),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                )
                Icon(
                    Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).align(Alignment.Start)
                        .offset(x = (4).dp, y = (-70).dp)
                )



                TextField(
                    value = notelepon,
                    onValueChange = {notelepon = it},
                    label = {
                        Text(text = "notelepon")
                    },
                    placeholder = { Text(text = "Isi notelepon Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp).clip(RoundedCornerShape(30.dp)),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Icon(
                    Icons.Filled.Call,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).align(Alignment.Start)
                        .offset(x = (4).dp, y = (-70).dp)
                )




                TextField(
                    value = alamat,
                    onValueChange = {alamat = it},
                    label = {
                        Text(text = "alamat")
                    },
                    placeholder = { Text(text = "Isi alamat Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp).clip(RoundedCornerShape(30.dp))

                )
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).align(Alignment.Start)
                        .offset(x = (4).dp, y = (-70).dp)
                )

                Text(text = "Tahun Masuk :")

                Row (modifier = Modifier.fillMaxWidth()){
                    dataGender.forEach { selectedGender ->
                        Row (verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = Gender == selectedGender,
                                onClick = { Gender = selectedGender }
                            )
                            Text(text = selectedGender, modifier = Modifier, Color.Blue)
                        }
                    }

                }



        Button(onClick = {

            ConfEmail = Email
            Confalamat = alamat
            Confnotelepon = notelepon
            ConfGender = Gender
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Simpan")
        }

                Text(text = "Data Kamu", modifier = Modifier.padding(10.dp))


        Biodata(para = "Email",
            arg = ConfEmail)
        Biodata(para = "notelepon",
            arg = Confnotelepon)
        Biodata(para = "alamat",
            arg = Confalamat)
                Biodata( para = "tahun masuk",
                    arg = ConfGender)


    }
}







@Composable
fun Biodata(
    para:String, arg:String
){
    Column (modifier = Modifier.padding(16.dp)) {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = para, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.1f))
            Text(text = arg, modifier = Modifier.weight(2f))

        }
    }
}
