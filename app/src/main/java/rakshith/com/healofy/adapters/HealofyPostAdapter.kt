package rakshith.com.healofy.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import rakshith.com.healofy.R
import rakshith.com.healofy.activities.CommentsActivity
import rakshith.com.healofy.models.HealofyPostsModel

/**
 * Created Healofy by rakshith on 7/8/18.
 */

class HealofyPostAdapter(mContext: Context?, healofyPostList: ArrayList<HealofyPostsModel>) : RecyclerView.Adapter<HealofyPostAdapter.HealofyPostViewHolder>(), View.OnClickListener {
    companion object {
        private var TAG: String = this.javaClass.simpleName
    }

    var mHealofyPostList = healofyPostList
    var mContext = mContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealofyPostViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return HealofyPostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mHealofyPostList.size
    }

    override fun onBindViewHolder(holder: HealofyPostViewHolder, position: Int) {
        var healofyModel = mHealofyPostList.get(position)

        holder.tvPostedBy?.text = healofyModel.name
        holder.tvPostTitle?.text = healofyModel.postTitle

        holder.llComment?.setOnClickListener(this)
        holder.llComment?.setTag(position)
    }

    class HealofyPostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tvPostedBy = itemView?.findViewById<TextView>(R.id.post_row_tv_posted_by)
        var tvPostTitle = itemView?.findViewById<TextView>(R.id.post_row_tv_post_title)
        var llLike = itemView?.findViewById<LinearLayout>(R.id.post_row_ll_like)
        var llComment = itemView?.findViewById<LinearLayout>(R.id.post_row_ll_comment)
    }

    override fun onClick(v: View?) {
        var selectedPositon = v?.getTag()
        when (v?.id) {
            R.id.post_row_ll_comment -> {
                var commentsIntent = Intent(mContext, CommentsActivity::class.java)
                mContext?.startActivity(commentsIntent)
            }
        }
    }
}