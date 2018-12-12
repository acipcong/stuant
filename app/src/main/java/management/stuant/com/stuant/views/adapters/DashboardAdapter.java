package management.stuant.com.stuant.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import management.stuant.com.stuant.R;
import management.stuant.com.stuant.models.DashboardItem;

/**
 * Created by USER on 11/25/2018.
 */

public class DashboardAdapter extends RecyclerView.Adapter< DashboardAdapter.FlowerViewHolder > {

    private Context mContext;
    private List<DashboardItem> mFlowerList;

    public DashboardAdapter(Context mContext, List< DashboardItem > mFlowerList) {
        this.mContext = mContext;
        this.mFlowerList = mFlowerList;
    }

    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_row_item, parent, false);
        return new FlowerViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final FlowerViewHolder holder, int position) {
        holder.mImage.setImageResource(mFlowerList.get(position).getDashboardImage());
        holder.mTitle.setText(mFlowerList.get(position).getDashboarLogoName());
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    class FlowerViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView mTitle;

        FlowerViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.ivImage);
            mTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}

