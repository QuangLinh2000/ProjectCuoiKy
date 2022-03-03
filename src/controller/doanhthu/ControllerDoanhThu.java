package controller.doanhthu;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.danhsachhoadon.IHoaDonTraPhong;
import controller.sodokhachsan.SubjectKhachHangDatPhong;
import model.KhachHangThuePhong;
import model.KhachSan;
import view.DoanhThuActivity;

public class ControllerDoanhThu implements IHoaDonTraPhong {
	DoanhThuActivity view;
	KhachSan khachSan;
    SubjectKhachHangDatPhong subjectKhachHangDatPhong;
	public ControllerDoanhThu(KhachSan khachSan,SubjectKhachHangDatPhong subjectKhachHangDatPhong) {
		this.khachSan = khachSan;
		this.subjectKhachHangDatPhong = subjectKhachHangDatPhong;
		subjectKhachHangDatPhong.dangKyKhachHangTraPhong(this);
		view = new DoanhThuActivity();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<KhachHangThuePhong> list = khachSan.getListCustomersRentingRooms();
		for (int i = 1; i <= 30; i++) {
			int result = 0;

			for (KhachHangThuePhong khachHangThuePhong2 : list) {
				if(khachHangThuePhong2.isStatus() == false && khachHangThuePhong2.getCheckOutDate().getDate() == i) {
					result++;
				}
			}
		
			

			dataset.addValue(result, "GDP", "" + i);

		}
		JFreeChart lineChart = ChartFactory.createLineChart(

				"Biểu đồ Doanh thu của chuổi cửa hàng".toUpperCase(),

				"Ngày", "Số Người", dataset,

				PlotOrientation.VERTICAL, false, false, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(844, 555));
		view.add(chartPanel);
	}

	public DoanhThuActivity getView() {
		return view;
	}

	@Override
	public void update(KhachHangThuePhong khachHangThuePhong) {
		view.removeAll();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<KhachHangThuePhong> list = khachSan.getListCustomersRentingRooms();
		for (int i = 1; i <= 30; i++) {
			int result = 0;

			for (KhachHangThuePhong khachHangThuePhong2 : list) {
				if(khachHangThuePhong2.isStatus() == false && khachHangThuePhong2.getCheckOutDate().getDate() == i) {

					result++;
				}
			}
		
			

			dataset.addValue(result, "GDP", "" + i);

		}
		JFreeChart lineChart = ChartFactory.createLineChart(

				"Biểu đồ Doanh thu của chuổi cửa hàng".toUpperCase(),

				"Ngày", "Số Người", dataset,

				PlotOrientation.VERTICAL, false, false, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(844, 555));
		view.add(chartPanel);
		view.validate();

	}

}
