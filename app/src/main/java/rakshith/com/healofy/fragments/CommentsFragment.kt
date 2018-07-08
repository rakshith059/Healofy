package rakshith.com.healofy.fragments

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_comments.*
import rakshith.com.healofy.R
import rakshith.com.healofy.adapters.HealofyCommentsAdapter
import rakshith.com.healofy.models.HealofyPostsModel

/**
 * Created Healofy by rakshith on 7/8/18.
 */


class CommentsFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.activity_comments, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var postAdapter: HealofyCommentsAdapter = HealofyCommentsAdapter(activity?.applicationContext as Context, createHealofyComments())
        activity_comments_rv_recyclerView?.adapter = postAdapter
    }

    private fun createHealofyComments(): ArrayList<HealofyPostsModel> {
        var commentsList = ArrayList<HealofyPostsModel>()
        for (index in 0..10) {
            commentsList.add(HealofyPostsModel("dummy name $index", "dummy post title $index"))
        }
        return commentsList
    }
}