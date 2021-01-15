//package com.android254.droidconKE2020.sessions.ui.views
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.content.ContextCompat
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.navigation.fragment.findNavController
//import com.android254.droidconKE2020.sessions.R
//import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
//import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
//import com.android254.droidconKE2020.sessions.ui.views.adapter.SaveSessionListener
//import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionClickListener
//import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsAdapter
//import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
//import com.android254.droidconKE2020.sessions.ui.views.models.DaySession
//import com.android254.droidconKE2020.sessions.ui.views.viewmodel.BookmarkedSessionsViewModel
//import com.google.android.material.tabs.TabLayout
//import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.*
//import kotlinx.android.synthetic.main.tab_session.view.*
//import org.koin.android.viewmodel.ext.android.viewModel
//
//
//class BookmarkedSessionsFragment : Fragment() {
//    private var _binding: FragmentBookmarkedSessionsBinding? = null
//    private val binding get() = _binding!!
//    private val bookmarkedSessionsViewModel: BookmarkedSessionsViewModel by viewModel()
//    private fun injectFeatures() = loadModules
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentBookmarkedSessionsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        injectFeatures()
//        getDaySessions()
//        observeDaySessions()
//        getBookmarkedSessions()
//        observeBookmarkedSessions()
//        onNavigateBack()
//        observeBackNavigation()
//        observeNavigateToSessionDetail()
//    }
//
////    private fun setUpTabs(daySessions: List<DaySession>) {
////        daySessions.forEach { daySession ->
////            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_session, null)
////            tabView.textViewDayDate.text = daySession.date
////            tabView.textViewDayName.text = daySession.dayText
////            tabView.textViewDayName.setTextColor(
////                ContextCompat.getColor(
////                    requireContext(),
////                    com.android254.droidconKE2020.R.color.colorGreen
////                )
////            )
////            tabView.layoutTabSession.background =
////                requireContext().resources.getDrawable(R.drawable.session_card_view_border, null)
////            binding.tabLayout.addTab(tabLayout.newTab().setCustomView(tabView))
////        }
////        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
////            override fun onTabSelected(tab: TabLayout.Tab?) {
////                val bookmarkedSessionsFragmentDirections =
////                    BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment()
////                findNavController().navigate( bookmarkedSessionsFragmentDirections)
////            }
////
////            override fun onTabUnselected(tab: TabLayout.Tab?) {}
////            override fun onTabReselected(tab: TabLayout.Tab?) {}
////        })
////    }
//
////    private fun observeDaySessions() {
////        sessionsViewModel.daySessions.observe(
////            viewLifecycleOwner,
////            Observer { daySessions ->
////                if (daySessions.isNotEmpty()) {
////                    setUpTabs(daySessions)
////                }
////            }
////        )
////    }
////
////    private fun getDaySessions() {
////        sessionsViewModel.getDaySessions()
////    }
//
//    private fun onNavigateBack() {
//        imageViewBackNavigation.setOnClickListener { _ ->
//            bookmarkedSessionsViewModel.onNavigateBack()
//        }
//    }
//
//    private fun observeBackNavigation() {
//        bookmarkedSessionsViewModel.isNavigateBack.observe(
//            viewLifecycleOwner,
//            Observer { isNavigateBack ->
//                isNavigateBack?.let {
//                    if (isNavigateBack) {
//                        bookmarkedSessionsViewModel.onNavigatedBack()
//                        val bookmarkedSessionsFragmentDirections =
//                            BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment()
//                        findNavController().navigate(bookmarkedSessionsFragmentDirections)
//                    }
//                }
//            })
//    }
//
//    private fun getBookmarkedSessions() {
//        bookmarkedSessionsViewModel.getBookMarkedSessions()
//    }
//
//    private fun observeBookmarkedSessions() {
//        bookmarkedSessionsViewModel.bookmarkedSessions.observe(
//            viewLifecycleOwner,
//            Observer { sessions ->
//                if (!sessions.isNullOrEmpty()) {
//                    setUpRvSessions(sessions)
//                }else{
//                    binding.noSessionsView.visibility = View.VISIBLE
//                }
//            }
//        )
//    }
//
////    private fun setUpRvSessions(sessions: List<DummySession>) {
////        val sessionsAdapter = SessionsAdapter(
////            sessions = sessions,
////            saveSessionListener = SaveSessionListener { session, view ->
////                session.isSessionSaved = false
////            },
////            sessionClickListener = SessionClickListener { sessionId ->
////                bookmarkedSessionsViewModel.onSessionItemClicked(sessionId = sessionId)
////            }
////        )
////        binding.rvSessionsSavedSessions.adapter = sessionsAdapter
////    }
//
//    private fun observeNavigateToSessionDetail() {
//        bookmarkedSessionsViewModel.navigateToSessionDetail.observe(
//            viewLifecycleOwner,
//            Observer { sessionId ->
//                sessionId?.let {
//                    bookmarkedSessionsViewModel.onSessionDetailNavigated()
//                    val bookmarkedSessionsFragmentDirections =
//                        BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionDetailsFragment(
//                            sessionId
//                        )
//                    findNavController().navigate(bookmarkedSessionsFragmentDirections)
//                }
//            }
//        )
//    }
//
//
//}