package mx.edu.itchetumal.myrfcroberto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Entradas de texto
        var txtNombre = findViewById<EditText>(R.id.txtName)
        var txtApellidoP = findViewById<EditText>(R.id.txtApe1)
        var txtApellidoM = findViewById<EditText>(R.id.txtApe2)

        //Botones
        var btnResult = findViewById<Button>(R.id.btnCalcular)
        var btnLimp = findViewById<Button>(R.id.btnLimpiar)

        //Spinners de los dias
        var spDia = findViewById<Spinner>(R.id.spDia)
        //Acceder a los elementos de dias
        val dias = resources.getStringArray(R.array.Days)
        val adaptador1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, dias)
        spDia.adapter = adaptador1


        //Spinner de los meses
        var spMes = findViewById<Spinner>(R.id.spMes)
        //Accedeer a los elementos de los meses
        val meses = resources.getStringArray(R.array.Mes)
        val adaptador2 = ArrayAdapter(this,android.R.layout.simple_spinner_item,meses)
        spMes.adapter = adaptador2


        //Spinner de los años
        var spAnio = findViewById<Spinner>(R.id.spYear)
        //Acceder a los elementos de los años
        val years = resources.getStringArray(R.array.Year)
        val adaptador3 = ArrayAdapter(this,android.R.layout.simple_spinner_item,years)
        spAnio.adapter = adaptador3

        //Validar si el primer nombre es diferente de jose o maria
        fun validaNombre(): String {
            var validName = " "
            var nombre = txtNombre.text.toString().toUpperCase()

            //Comprobar si el nombre es igual a José o jose
            if (nombre[0].toLowerCase() == 'j' && nombre[1].toLowerCase() == 'o' && nombre[2].toLowerCase() == 's' && nombre[3].toLowerCase() == 'e' || nombre[3].toLowerCase() == 'é' ){
                validName = nombre[5].toString().toUpperCase() //Si el primer nombre es igual a jose, tomaremos la inicial del segundo nombre
            } //Comprobar si el nombre es igual a María
            else if (nombre[0].toLowerCase() == 'm' && nombre[1].toLowerCase() == 'a' && nombre[2].toLowerCase() == 'r' && nombre[3].toLowerCase() == 'i' || nombre[3].toLowerCase() == 'í' && nombre[4].toLowerCase() == 'a') {
                validName = nombre[6].toString().toUpperCase() //Si el primer nombre es igual a maria, tomamos el primer caracter del segundo nombre
            } //Comprobar si existe un caracter despues de un nombre que incluya la palabra Maria. Ejemplo Marian
            else if (nombre[1].toLowerCase() == 'a' && nombre[2].toLowerCase() == 'r' && nombre[3].toLowerCase() == 'i' || nombre[3].toLowerCase() == 'í' && nombre[4].toLowerCase() == 'a' && nombre[5].toLowerCase() == 'n') {
                validName = nombre[0].toString().toUpperCase()
            } else {
                validName = nombre[0].toString().toUpperCase()
            }
            return validName.toString()
        }

        //primera vocal de apellido paterno
        fun primerVocal(): String {
            var primerVocal = " "
            var apellidoP = txtApellidoP.text.toString().toUpperCase()
            if (apellidoP[1].toLowerCase() == 'a' || apellidoP[1].toLowerCase() == 'e' || apellidoP[1].toLowerCase() == 'i' || apellidoP[1].toLowerCase() == 'o' || apellidoP[1].toLowerCase() == 'u' ){
                primerVocal = apellidoP[1].toString().toUpperCase()
            } else {
                primerVocal = apellidoP[2].toString().toUpperCase()
            }
            return primerVocal.toString()
        }


        //Generar la homoclave
        fun generarHomoclave(): String {
            var homoclave = " "
            val valores = mutableListOf("A","B","C","D","E","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","U","V","X","Y","Z","0",
                "1","2","3","4","5","6","7","8","9")
            val caracter1 = valores.random()
            val caracter2 = valores.random()
            val caracter3 = valores.random()
            homoclave = caracter1 + caracter2 + caracter3

            return homoclave.toString()
        }

        //Calcular RFC
        btnResult.setOnClickListener {
            var apellidoP = txtApellidoP.text.toString().toUpperCase()
            var apellidoM = txtApellidoM.text.toString().toUpperCase()
            //var nombre = txtNombre.text.toString().toUpperCase()

            //var dia = spDia.toString()
            var dia = spDia.selectedItem.toString()

            //var mes = spMes.toString()
            var mes = spMes.selectedItem.toString()

            //var anio = spAnio.toString()
            var anio = spAnio.selectedItem.toString()

            var aP = apellidoP[0].toString()
            //+ apellidoP[1].toString()
            var aM = apellidoM[0].toString()
            //var nm = nombre[0].toString()

            var an1 = anio[2]
            var an2 = anio[3]
            var m = mes
            var d = dia

            var caracteres = aP +primerVocal()+ aM +  validaNombre() + an1 + an2 + m + d + generarHomoclave()

            var rfcResut = findViewById<TextView>(R.id.txtRfc)
            rfcResut.text = caracteres

        }



        //Limpiar datos de la pantalla obtener otro RFC
        btnLimp.setOnClickListener {
            txtNombre.setText("")
            txtApellidoP.setText("")
            txtApellidoM.setText("")
        }






    }
}