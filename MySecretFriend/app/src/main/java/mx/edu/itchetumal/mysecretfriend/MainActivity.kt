package mx.edu.itchetumal.mysecretfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>

        val personas = mutableListOf("Roberto","Sofia","Carlos","Max","Jose","Marian","Valentina")

        val lvData = findViewById<ListView>(R.id.lvData)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, personas)
        lvData.adapter = arrayAdapter

        lvData.setOnItemClickListener(){parent, view, position, id ->

            Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }

        var txtNombre = findViewById<EditText>(R.id.txtName)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnResult = findViewById<Button>(R.id.btnResult)
        var nombre = txtNombre.text

        btnAdd.setOnClickListener {
            personas.add(nombre.toString())
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, personas)
            lvData.adapter = arrayAdapter
            arrayAdapter.notifyDataSetChanged()
        }
    }
}