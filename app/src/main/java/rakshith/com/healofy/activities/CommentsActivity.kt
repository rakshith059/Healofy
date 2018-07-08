package rakshith.com.healofy.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.fragment_main.*
import rakshith.com.healofy.R
import rakshith.com.healofy.adapters.HealofyCommentsAdapter
import rakshith.com.healofy.models.HealofyPostsModel

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        var postAdapter: HealofyCommentsAdapter = HealofyCommentsAdapter(this@CommentsActivity, createHealofyComments())
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
