package com.example.vova_degtyarev_prekol.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.vova_degtyarev_prekol.Product
import com.example.vova_degtyarev_prekol.R
import kotlinx.android.synthetic.main.cart_list.view.*

class CartListAdapter(
    private val onDeleteClick: (Product) -> Unit
) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    private var cartList: List<Product> = listOf()

    fun setData(cartList: List<Product>) {
        this.cartList = cartList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_list, parent, false) as ConstraintLayout
        )

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((cartList[position]))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            itemView.cartProductTv.text = product.getProductName()
            itemView.cartPriceIV.text = "${product.getPrice().toString()} руб"
            itemView.cartDiscountIV.text = "скидка - ${product.getDiscount().toString()}%"
            itemView.cartDeleteIv.setOnClickListener {
                onDeleteClick(product)
            }
        }
    }
}