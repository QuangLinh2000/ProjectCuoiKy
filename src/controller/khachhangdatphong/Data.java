package controller.khachhangdatphong;

import java.util.ArrayList;
import java.util.List;

public class Data implements Suject{
	List<ObserVer> list = new ArrayList<ObserVer>();
	

	@Override
	public void updateDenO(String i) {
		for (ObserVer obserVer : list) {
			obserVer.updateKhacDenO(i);
		}
		
	}

	@Override
	public void dangKy(ObserVer ob) {
		list.add(ob);
		
	}

	@Override
	public void huyDatPhong(String tenPhong) {
		for (ObserVer obserVer : list) {
			obserVer.huyDatPhong(tenPhong);
		}
		
	}

}
