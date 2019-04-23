package com.salton123.bookmarksbrowser.ui.fm;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;

import com.salton123.base.BaseFragment;
import com.salton123.bookmarksbrowser.R;
import com.salton123.bookmarksbrowser.bean.GridBookmarkItem;
import com.salton123.view.adapter.BookmarkGridAdapter;

/**
 * User: newSalton@outlook.com
 * Date: 2019/4/23 15:44
 * ModifyTime: 15:44
 * Description:
 */
public class BookMarkGridFragment extends BaseFragment {
    private GridView gridView;
    private BookmarkGridAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.comp_book_mark_grid;
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {
        mAdapter = new BookmarkGridAdapter(activity());
        for (int i = 0; i < 30; i++) {
            mAdapter.add(new GridBookmarkItem("最新合集" + i, "www.baidu.comwww.baidu.com", Color.BLUE));
        }
    }

    @Override
    public void initViewAndData() {
        gridView = f(R.id.gridView);
        gridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
