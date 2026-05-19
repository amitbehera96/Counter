package com.ab.counter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ab.counter.ui.viewmodel.CounterViewModel


@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel = hiltViewModel()
) {
    val count by counterViewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Counter Value",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = count.toString(),
                    fontSize = 60.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            counterViewModel.decrement()
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {

                        Text(
                            text = "-",
                            fontSize = 24.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Button(
                        onClick = {
                            counterViewModel.increment()
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {

                        Text(
                            text = "+",
                            fontSize = 24.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }

            Button(
                onClick = {
                    counterViewModel.resetCounter()
                },
                shape = RoundedCornerShape(12.dp)
            ) {

                Text(
                    text = "Reset",
                    fontSize = 24.sp
                )
            }
        }


    }
}