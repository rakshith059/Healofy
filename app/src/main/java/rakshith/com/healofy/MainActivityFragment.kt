package rakshith.com.healofy

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import rakshith.com.healofy.adapters.HealofyPostAdapter
import rakshith.com.healofy.models.HealofyPostsModel

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var postAdapter: HealofyPostAdapter = HealofyPostAdapter(activity?.applicationContext, createHealofyPosts())
        fragment_main_rv_recyclerView?.adapter = postAdapter
    }

    private fun createHealofyPosts(): ArrayList<HealofyPostsModel> {
        var postList = ArrayList<HealofyPostsModel>()
        for (index in 0..10) {
            postList.add(HealofyPostsModel("dummy name $index", "dummy post title $index"))
        }
        return postList
    }
}
