package be.equality.metar.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tjorv.hackthefuture.R
import be.equality.metar.model.Airport
import com.example.tjorv.hackthefuture.model.Supply
import com.example.tjorv.hackthefuture.fragments.BaseFragment
import com.example.tjorv.hackthefuture.viewModels.MainViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_airports.*
import kotlinx.android.synthetic.main.row_layout.view.*


/**
 * A simple [Fragment] subclass which show the list of Airports available.
 * Activities that contain this fragment must implement the
 * [AirportsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AirportsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AirportsFragment : Fragment() {

    /**
     * The listener to interact with other Activities and Fragments
     */
    private var listener: OnFragmentInteractionListener? = null

    /**
     * List containing the aiports for which a METAR can be requested.
     */
    private var supplies: List<Supply>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airports, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //observeViewModel(viewModel)
    }

    override fun onStart() {
        super.onStart()
        //TODO
        recyclerview.adapter = SimpleItemRecyclerViewAdapter(supplies!!)
        recyclerview.layoutManager = LinearLayoutManager(context)
    }

    /**
     * Casting the activity to an [OnFragmentInteractionListener]
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        TAG = "SuppliesFragment"


        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    /**
     * Releases the listener of this Fragment when the Fragment is detached.
     */
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun showAirportMetar()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment AirportsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AirportsFragment()
    }
}
