package com.acorn.foldnavscrolllayout;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class TestFragment extends BaseFragment {
    private String[] imgUrls = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556449926916&di=da25d109bce4b7bcbbcec6cef1c9446c&imgtype=0&src=http%3A%2F%2Ffiles.xubei.com%2FsafeguardRights-img%2Fe19622b55b404f358a6bdda1d166bbd1.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556449965154&di=1e19181dcec0a9228b43cb39d1883850&imgtype=0&src=http%3A%2F%2F3ds.tgbus.com%2FUploadFiles%2F201205%2F20120504143424110.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557044726&di=657f7761708ec8682b9f04d0772cbe5d&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.game333.net%2Fuploads%2Fnews%2F2015%2F07%2F01%2F2015070141515366.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556450006660&di=64f090b0cc5687c0b0fa5f41ac20d400&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fb007ee4a1f03118a96284e5d2b1126ac1181fdc72882d-bZWQXl_fw236",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556450039592&di=d5e95f83c514edf64a88561e2e0d1ab1&imgtype=0&src=http%3A%2F%2F3ds.tgbus.com%2FUploadFiles%2F201510%2F20151013105427116.png",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556450049814&di=6f9f9887fc4ac1608af1897f8ecf1cbc&imgtype=0&src=http%3A%2F%2Fwww.k73.com%2Fup%2Farticle%2F2014%2F1016%2F215955_97343773.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556450081350&di=edca4ebb60f6d298e89fc2ba3710be83&imgtype=0&src=http%3A%2F%2Fimg.haote.com%2Fupload%2Fnews%2Fimage%2F20180730%2F20180730171804_50921.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=874419642,1637970189&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556450131073&di=30c2bee79a82d719763fd852f6161257&imgtype=0&src=http%3A%2F%2Fresource.58game.com%2Fuploads%2Fcontent%2F20150710%2F559f639c1f6c5.jpg"
    };
    private RecyclerView rv;

    public static TestFragment newInstance() {
        Bundle args = new Bundle();

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void findViews() {
        rv = (RecyclerView) findViewById(R.id.test_rv);

        rv.setFocusableInTouchMode(false);
        rv.setFocusable(false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv.setAdapter(new TestAdapter(getContext(), imgUrls));
    }

    @Override
    protected void setupListener() {

    }
}
