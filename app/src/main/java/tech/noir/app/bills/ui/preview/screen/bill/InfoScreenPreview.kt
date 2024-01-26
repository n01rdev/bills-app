package tech.noir.app.bills.ui.preview.screen.bill

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.noir.app.bills.R
import tech.noir.app.bills.core.ui.theme.BillsTheme

@Composable
fun InfoScreenPreview() {
    // Establecer el color de fondo azul para toda la pantalla con un relleno adicional
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Blue)
            .padding(16.dp) // Relleno adicional para extender el color al borde del dispositivo
    ) {
        // Título en la esquina superior izquierda
        Text(
            text = "Pestaña abierta",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )

        // Box que representa la pestaña abierta del móvil
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp)
                .background(
                    color = Color.White, // Color de fondo de la pestaña
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .padding(
                    top = 32.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ) // Relleno adicional para igualar el grosor al fondo azul y agregar más espacio en la parte superior
        ) {
            // Contenido de la pestaña abierta
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos en el Column
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close), // Cambia "ic_close" con el ID de tu imagen de la "X"
                    contentDescription = "Cerrar",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* Acción al hacer clic en la "X" */ }
                        .align(Alignment.End) // Alinea la imagen a la derecha
                )
                Image(
                    painter = painterResource(id = R.drawable.bills), // Cambia "ic_close" con el ID de tu imagen de la "X"
                    contentDescription = "Cerrar",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* Acción al hacer clic en la "X" */ }
                )

                Text(
                    text = "Información de facturas",
                    color = Color.Black, // Color del texto
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp) // Agrega un margen en la parte superior del texto
                )
                Text(
                    text = "Hemos conectado los detalles de tu cuenta.",
                    color = Color.Gray, // Color del texto
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 16.dp) // Agrega un margen en la parte superior del texto
                )
                Text(
                    text = "Por favor verifique sus detalles",
                    color = Color.Gray, // Color del texto
                    fontSize = 8.sp,
                    modifier = Modifier.padding(top = 16.dp) // Agrega un margen en la parte superior del texto
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp) // Margen desde arriba
                        .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Número del consumidor:",
                                color = Color.Black,
                                fontSize = 8.sp
                            )
                            // Aquí puedes agregar la imagen a la derecha del nombre del consumidor
                            Image(
                                painter = painterResource(id = R.drawable.bar_code),
                                contentDescription = "Imagen del consumidor",
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Text(
                            text = "102340000001243",
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Fecha de la factura:",
                            color = Color.Black,
                            fontSize = 8.sp
                        )
                        Text(
                            text = "30/12/2024",
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Importe Adecuado",
                            color = Color.Black,
                            fontSize = 8.sp
                        )
                        Text(
                            text = "2693.40$",
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }

                // Textos debajo del cuadro gris
                Row(
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nombre de la compañía:",
                        color = Color.Black,
                        fontSize = 10.sp,
                    )
                    Text(
                        text = "Juana Company",
                        color = Color.Black,
                        fontSize = 9.sp,
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nombre de la sección:",
                        color = Color.Black,
                        fontSize = 10.sp,
                    )
                    Text(
                        text = "Maripili",
                        color = Color.Black,
                        fontSize = 9.sp,
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nombre del Titular:",
                        color = Color.Black,
                        fontSize = 10.sp,
                    )
                    Text(
                        text = "Jaime Mateo",
                        color = Color.Black,
                        fontSize = 9.sp,
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun InfoScreenPreviewLight() {
    BillsTheme {
        InfoScreenPreview()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InfoScreenPreviewDark() {
    BillsTheme {
        InfoScreenPreview()
    }
}

