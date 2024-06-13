package br.com.fiap.easyinbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val currentEmail = emailList[position]
        holder.bind(currentEmail)
    }

    override fun getItemCount() = emailList.size

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        private val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        private val previewTextView: TextView = itemView.findViewById(R.id.previewTextView)
//        private val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
//        private val bookmarkImageView: ImageView = itemView.findViewById(R.id.bookmarkImageView)

        fun bind(email: Email) {
            senderTextView.text = email.sender
            categoryTextView.text = email.category
            previewTextView.text = email.messagePreview
//            timeTextView.text = email.time
//            bookmarkImageView.visibility = if (email.isBookmarked) View.VISIBLE else View.GONE
        }
    }
}
