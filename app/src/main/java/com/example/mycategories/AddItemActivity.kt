package com.example.mycategories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddItemActivity : AppCompatActivity() {
    private lateinit var ItemNameEdit: EditText
    private lateinit var addItemToCategoryButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        ItemNameEdit= findViewById(R.id.itemNameEditText)
        addItemToCategoryButton=findViewById(R.id.addItemToCategory)

        //retrieve the name passed from the main.activity

        val categoryName=intent.getStringExtra("CATEGORY_NAME")
        addItemToCategoryButton.setOnClickListener{

            val itemName=ItemNameEdit.text.toString()
            if(itemName.isNotEmpty()&&categoryName!=null){

                println("Category:$categoryName, Item:$itemName")
                finish()
            }
        }
    }
}