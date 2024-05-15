package com.example.mycategories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mycategories.R.id.categoryListTextView

class MainActivity : AppCompatActivity() {
    private lateinit var categoryNameEdit: EditText
    private lateinit var itemEditText: EditText
    private lateinit var addCategoryButton: Button
    private lateinit var addItemButton: Button
    private lateinit var categoryListTextView: TextView
    private val categories= mutableListOf<Category>()
    private val stringBuilder = StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryNameEdit=findViewById(R.id.categoryNameEdit)
        addCategoryButton=findViewById(R.id.addCategoryButton)
        addItemButton=findViewById(R.id.addItemButton)
        itemEditText=findViewById(R.id.itemEditText)
        categoryListTextView=findViewById(R.id.categoryListTextView)


        addCategoryButton.setOnClickListener {

            val categoryName=categoryNameEdit.text.toString()
            if(categoryName.isNotEmpty()){

                val category=Category(categoryName)
                categories.add(category)
                updateCategoryList()

                // Call the onCategoryAdded function to navigate to the AddItemActivity
                onCategoryAdded(categoryName)
            }
        }
        addItemButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddItemActivity::class.java))

        }
    }


    private fun onCategoryAdded(categoryName: String) {
        // Call the openLogin function to navigate to the AddItemActivity
        openLogin(categoryName)
        categoryListTextView.text = stringBuilder.toString()


    }

    private fun openLogin(categoryName: String) {
        // Launch the AddItemActivity
        val intent = Intent(this, AddItemActivity::class.java)
        intent.putExtra("CATEGORY_NAME", categoryName)
        startActivity(intent)

    }

    private fun updateCategoryList() {
      val stringBuilder= StringBuilder()
        for(category in categories){
            stringBuilder.append("${category.name}:${category.items.joinToString(",") }\n")
        }
    }
}