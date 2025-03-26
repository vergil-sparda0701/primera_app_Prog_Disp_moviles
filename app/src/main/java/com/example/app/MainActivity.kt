package com.example.app
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private  val messages : List<MyMessage> = listOf(
    MyMessage("Estudiante 1:", "Nixon En esta actividad, los estudiantes crearán una infografía sobre los principales componentes de Jetpack Compose. A través de un diseño visual atractivo, explicarán la función y el uso de elementos clave como botones, listas, navegación, manejo de estado y animaciones.\n" +
            "\n" +
            "El objetivo es sintetizar la información de manera clara y didáctica, utilizando gráficos, ejemplos y descripciones breves para facilitar la comprensión de estos conceptos esenciales en el desarrollo de aplicaciones móviles."),
    MyMessage("Estudiante 2:", "Nixon En esta actividad, los estudiantes crearán una infografía sobre los principales componentes de Jetpack Compose. A través de un diseño visual atractivo, explicarán la función y el uso de elementos clave como botones, listas, navegación, manejo de estado y animaciones.\n" +
            "\n" +
            "El objetivo es sintetizar la información de manera clara y didáctica, utilizando gráficos, ejemplos y descripciones breves para facilitar la comprensión de estos conceptos esenciales en el desarrollo de aplicaciones móviles."),
    MyMessage("Estudiante 3:", "Nixon En esta actividad, los estudiantes crearán una infografía sobre los principales componentes de Jetpack Compose. A través de un diseño visual atractivo, explicarán la función y el uso de elementos clave como botones, listas, navegación, manejo de estado y animaciones.\n" +
            "\n" +
            "El objetivo es sintetizar la información de manera clara y didáctica, utilizando gráficos, ejemplos y descripciones breves para facilitar la comprensión de estos conceptos esenciales en el desarrollo de aplicaciones móviles."),
    MyMessage("Estudiante 4:", "Nixon"),
    MyMessage("Estudiante 5:", "Nixon"),
    MyMessage("Estudiante 5:", "Nixon"),
    MyMessage("Estudiante 5:", "Nixon"))


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContent{
                PersonalData(name = "Nixon")
            }
    }
}
@Composable
private fun PersonalData (name: String){
    MaterialTheme (){
        Column (modifier = Modifier.padding(10.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(R.drawable.compose2),
                contentDescription = "Esta es una imágen de jetpack",
                modifier = Modifier.height(200.dp)
            )
            Text(text="Mi nombre es $name", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Soy Nixon", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Estoy aprendiendo JetPack Compose")

            val scrollState = rememberScrollState()
            Column (modifier = Modifier.verticalScroll(scrollState)) {
                MyMessages(messages)
            }
        }
    }
}

//funcion que imprimira una lista de mensajes
@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages){message -> MyComponent(message) }
    }
}

@Composable
fun MyComponent(message: MyMessage){
    Row (modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(8.dp)){
        MyImage()
        MyTexts(message)
    }
}


data class MyMessage (val title: String, val body: String)

// funcion que recopila_todo lo que esta dentro de MyText
@Composable
fun MyTexts(message: MyMessage){

    var expanded by remember { mutableStateOf(false) }
    Column (modifier = Modifier.padding(start = 8.dp).clickable {
       expanded = !expanded
    }){
        Spacer(modifier = Modifier.height(16.dp))
        MyText(message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium,
            if (expanded) Int.MAX_VALUE else 1)
        Spacer(modifier = Modifier.height(10.dp))
        MyText(message.body,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineSmall,
            if (expanded) Int.MAX_VALUE else 1 )
    }
}

// funcion para escribir texto
@Composable
fun MyText (text:String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

//funcion para imprimir una imagen
@Composable
fun MyImage(){
    Image(
        painter = painterResource(R.drawable.compose1),
        contentDescription = "Este es mi logo",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(70.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun previewCOmposable(){
    MyMessages(messages)
}



