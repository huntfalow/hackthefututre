package be.equality.metar.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tjorv.hackthefuture.R
import com.example.tjorv.hackthefuture.model.Supply
import com.example.tjorv.hackthefuture.fragments.BaseFragment
import com.example.tjorv.hackthefuture.viewModels.MainViewModel
import com.orhanobut.logger.Logger
import android.R
import com.google.android.gms.maps.SupportMapFragment




/**
 * A simple [Fragment] subclass which show the list of Airports available.
 * Activities that contain this fragment must implement the
 * [AirportsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AirportsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QrFragment : Fragment() {

    /**
     * The listener to interact with other Activities and Fragments
     */
    private var listener: OnFragmentInteractionListener? = null

    /**
     * List containing the aiports for which a METAR can be requested.
     */
    private var supplies: ArrayList<Supply> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_item_supply, container, false)

        //maps

        super.onCreate(savedInstanceState)
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps)
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        val mapFragment = getSupportFragmentManager()
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
        //TODO Implement
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
