package com.task.taskgift.nilai.adapter

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.task.taskgift.R
import com.task.taskgift.nilai.data.NilaiWali

class RecycleViewNilaiWaliAdapter(private val NilaiWaliList: List<NilaiWali>) :
    RecyclerView.Adapter<RecycleViewNilaiWaliAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bar_chart_nilai_wali, parent, false)
            return ViewHolder(view)
        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val NilaiWaliData = NilaiWaliList[position]

        val barEntries = mutableListOf<BarEntry>()
        barEntries.add(BarEntry(1f, NilaiWaliData.nilaiTugas))
        barEntries.add(BarEntry(2f, NilaiWaliData.nilaiUlanganHarian))
        barEntries.add(BarEntry(3f, NilaiWaliData.nilaiUTS))
        barEntries.add(BarEntry(4f, NilaiWaliData.nilaiUAS))

        val colors = mutableListOf<Int>()
        colors.add(Color.rgb(16,33,90))
        colors.add(Color.GREEN)
        colors.add(Color.YELLOW)
        colors.add(Color.RED)

        val xAxis = holder.barChart.xAxis
        xAxis.isEnabled = false

        val yAxisRight = holder.barChart.axisRight
        yAxisRight.isEnabled = false

        holder.barChart.description.isEnabled = false
        holder.barChart.legend.isEnabled = false
        holder.barChart.setFitBars(true)
        holder.barChart.axisLeft.axisMinimum = 0f
        holder.barChart.animateY(1000)
        holder.barChart.setDrawValueAboveBar(false)


        val dataSet = BarDataSet(barEntries, "Grades")
        dataSet.setDrawValues(false)
        dataSet.colors = colors
        val barData = BarData(dataSet)

        holder.barChart.data = barData
        holder.tvNilaiTitle.text = NilaiWaliList[position].namaMataPelajaran
    }

    override fun getItemCount(): Int {
        return NilaiWaliList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cvBarChartNilaiWali : CardView = itemView.findViewById(R.id.cvBarchartNilaiWali)
        val tvNilaiTitle : TextView = itemView.findViewById(R.id.nama_mata_pelajaran)
        val barChart: BarChart = itemView.findViewById(R.id.barchartNilaiWali)
    }
}