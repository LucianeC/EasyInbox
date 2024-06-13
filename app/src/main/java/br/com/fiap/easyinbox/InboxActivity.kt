package br.com.fiap.easyinbox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InboxActivity : AppCompatActivity() {

    private lateinit var emailAdapter: EmailAdapter
    private lateinit var emailList: List<Email>
    private lateinit var filteredEmailList: MutableList<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)

        emailList = getEmails()
        filteredEmailList = emailList.toMutableList()

        emailAdapter = EmailAdapter(filteredEmailList)

        val emailRecyclerView = findViewById<RecyclerView>(R.id.emailRecyclerView)
        emailRecyclerView.layoutManager = LinearLayoutManager(this)
        emailRecyclerView.adapter = emailAdapter

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterEmails(newText)
                return true
            }
        })

//        val composeEmailButton = findViewById<Button>(R.id.composeEmailButton)
//        composeEmailButton.setOnClickListener {
//            val intent = Intent(this, ComposeEmailActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun filterEmails(query: String?) {
        filteredEmailList.clear()
        if (query.isNullOrEmpty()) {
            filteredEmailList.addAll(emailList)
        } else {
            val lowerCaseQuery = query.lowercase()
            filteredEmailList.addAll(emailList.filter {
                it.sender.lowercase().contains(lowerCaseQuery) ||
                        it.category.lowercase().contains(lowerCaseQuery) ||
                        it.messagePreview.lowercase().contains(lowerCaseQuery) ||
                        it.time.lowercase().contains(lowerCaseQuery)
            })
        }
        emailAdapter.notifyDataSetChanged()
    }

    private fun getEmails(): List<Email> {
        return listOf(
            Email("FIAP", "Estudos", "Texto do E-mail", "12:23", false),
            Email("LinkedIn", "Redes Sociais", "Texto do E-mail", "11:38", false),
            Email("Instagram", "Redes Sociais", "Texto do E-mail", "09:13", false),
            // Adicione mais emails conforme necessário
        )
    }
}
