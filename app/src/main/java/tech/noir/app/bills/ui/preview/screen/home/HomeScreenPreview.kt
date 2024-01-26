package tech.noir.app.bills.ui.preview.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.rememberNavController
import tech.noir.app.bills.R
import tech.noir.app.bills.core.ui.theme.BillsTheme
import tech.noir.app.bills.navigation.presentation.components.BottomNavigation

@Composable
fun HomeScreenPreview() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (content, bottomNav) = createRefs()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp) // Reserva espacio para el BottomNavigation
                .constrainAs(content) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomNav.top)
                }
        ) {
            // Título en la esquina superior izquierda
            Text(
                text = "Buen Lunes, Jaime",
                modifier = Modifier.padding(8.dp),
                fontSize = 18.sp
            )

            // Box con bordes redondos debajo del título
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Tus últimos ingresos",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "2.982$",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Última sincronización         20/12/2024",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }

            // Nuevo apartado debajo del Box azul
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Total consumido",
                        color = Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "1500  Unidades", // Puedes cambiar este valor según tus necesidades
                        color = Color.Black,
                        fontSize = 24.sp
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("+")
                            }
                            withStyle(style = SpanStyle(color = Color.Green)) {
                                append("045%")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("  de la última semana")
                            }
                        },
                        fontSize = 15.sp
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.tablaup), // Reemplaza 'tabla' con el nombre real de tu imagen
                    contentDescription = null, // Puedes proporcionar una descripción aquí
                    modifier = Modifier
                        .size(140.dp)
                )
            }

            // Divider debajo del último bloque de texto
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .height(100.dp)
                        .padding(16.dp)
                        .background(color = Color.LightGray),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically // Centra verticalmente los elementos del Row
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        ) {
                            Text(
                                text = "6 meses",
                                color = Color.Cyan,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(16.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center // Centra el contenido horizontalmente
                        ) {
                            Text(
                                text = "1 año",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
            // Nuevo apartado debajo de la caja principal
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                // Texto "Unidades consumidas" con bloque azul
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(color = Color.Blue)
                            .padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Espacio adicional
                    Text(
                        text = "Unidades consumidas",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(color = Color.Magenta)
                            .padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Espacio adicional
                    Text(
                        text = "Cantidad Pagada",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                // Nuevo apartado debajo de los textos y el Divider
                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.tabladown), // Reemplaza 'whatsapp_image_2024_01_25' con el nombre real de tu imagen
                    contentDescription = null, // Puedes proporcionar una descripción aquí
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }

        Box(
            modifier = Modifier
                .constrainAs(bottomNav) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            BottomNavigation(rememberNavController())
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun InfoScreenPreviewLight() {
    BillsTheme {
        HomeScreenPreview()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InfoScreenPreviewDark() {
    BillsTheme {
        HomeScreenPreview()
    }
}