package com.example.ftapp;

import android.bluetooth.le.ScanSettings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter
{


    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:

                RequestFragment requestFragment=new RequestFragment();
                return requestFragment;

            case 1:
                ChatsFragment chatsFragment=new ChatsFragment();
                return chatsFragment;

            case 2:
                FriendsFragment friendsFragment=new FriendsFragment();
                return  friendsFragment;
            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0:
                return "REQUEST";

            case 1:
                return "CHATS";
            case 2:
                return "FRİENDS";
            default:
                return null;


        }


        return super.getPageTitle(position);

}}
