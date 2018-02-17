package tech.simsec.android.view.accounts

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList

class AccountListViewModel : ViewModel() {

    private val accounts: MutableLiveData<PagedList<AccountListItem>> by lazy {
        MutableLiveData<PagedList<AccountListItem>>()
    }

    fun getAccounts(): LiveData<PagedList<AccountListItem>> {
        return accounts
    }

    fun load() {

    }

}