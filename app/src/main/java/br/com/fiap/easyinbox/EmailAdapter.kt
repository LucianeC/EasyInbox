package br.com.fiap.easyinbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(
    private val emailList: List<Email>,
    private val onClick: (Email) -> Unit
) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.bind(email)
        holder.itemView.setOnClickListener { onClick(email) }
    }

    override fun getItemCount() = emailList.size

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val senderTextView: TextView = itemView.findViewById(R.id.emailSenderTextView)
        private val categoryTextView: TextView = itemView.findViewById(R.id.emailCategoryTextView)
        private val messagePreviewTextView: TextView = itemView.findViewById(R.id.emailMessagePreviewTextView)
        private val timeTextView: TextView = itemView.findViewById(R.id.emailTimeTextView)
//        private val bookmarkImageView: ImageView = itemView.findViewById(R.id.emailBookmarkImageView)

        fun bind(email: Email) {
            senderTextView.text = email.sender
            categoryTextView.text = "Categoria: ${email.category}"
            messagePreviewTextView.text = email.messagePreview
            timeTextView.text = email.time
//             bookmarkImageView.setImageResource(if (email.isBookmarked) R.drawable.ic_bookmarked else R.drawable.ic_bookmark)
        }
    }
}
