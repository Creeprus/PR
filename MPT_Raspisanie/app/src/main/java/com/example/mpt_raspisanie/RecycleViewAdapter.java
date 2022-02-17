package com.example.mpt_raspisanie;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>
{
    private final LayoutInflater inflater;
    private final List<Model> ParaDay;

    public RecycleViewAdapter(Context context, List<Model> ParaDay) {
        this.ParaDay = ParaDay;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model=ParaDay.get(position);
        holder.TableTextDay.setText((model.getDay()));
        holder.TableTextPara11.setText((model.getPara11()));holder.TableTextPara12.setText((model.getPara12()));
        if( holder.TableTextPara12.getText()=="")
        {
            holder.TableTextPara12.setBackgroundColor(Color.WHITE);holder.TableTextPara11.setBackgroundColor(Color.WHITE);
        }
        holder.TableTextPara2.setText((model.getPara2()));
        holder.TableTextPara31.setText((model.getPara31()));holder.TableTextPara32.setText((model.getPara32()));
        if( holder.TableTextPara32.getText()=="")
        {
            holder.TableTextPara32.setBackgroundColor(Color.WHITE);holder.TableTextPara31.setBackgroundColor(Color.WHITE);
        }
        holder.TableTextPara41.setText((model.getPara41())); holder.TableTextPara42.setText((model.getPara42()));
        if( holder.TableTextPara42.getText()=="")
        {
            holder.TableTextPara42.setBackgroundColor(Color.WHITE);holder.TableTextPara41.setBackgroundColor(Color.WHITE);
        }
        holder.TableTextPara5.setText((model.getPara5()));
        holder.TableTextPara6.setText((model.getPara6()));
    }


    @Override
    public int getItemCount(){return  ParaDay.size();}
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        final TextView TableTextDay;
        final TextView TableTextPara11; final TextView TableTextPara12;
        final TextView TableTextPara2;
        final TextView TableTextPara31;final TextView TableTextPara32;
        final TextView TableTextPara41;final TextView TableTextPara42;
        final TextView TableTextPara5;
        final TextView TableTextPara6;
        public ViewHolder(@NonNull View view) {
            super(view);
            TableTextDay=view.findViewById(R.id.tableday);
            TableTextPara11=view.findViewById(R.id.tablepara11);   TableTextPara12=view.findViewById(R.id.tablepara12);
            TableTextPara2=view.findViewById(R.id.tablepara2);
            TableTextPara31=view.findViewById(R.id.tablepara31);   TableTextPara32=view.findViewById(R.id.tablepara32);
            TableTextPara41=view.findViewById(R.id.tablepara41);  TableTextPara42=view.findViewById(R.id.tablepara42);
            TableTextPara5=view.findViewById(R.id.tablepara5);
            TableTextPara6=view.findViewById(R.id.tablepara6);
        }
    }
}
