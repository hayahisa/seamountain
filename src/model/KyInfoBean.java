package model;

import java.util.ArrayList;

public class KyInfoBean {

	public KyInfoBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private ArrayList<KyBean> Ky_MoreBean = new ArrayList<KyBean>();

	private static final long serialVersionUID = 1L;
	public ArrayList<KyBean> getKyArray() {
		return Ky_MoreBean;
		}
	public void setKyArray(ArrayList<KyBean> ky_MoreBean) {
		this.Ky_MoreBean = Ky_MoreBean;
		}
	public void addky(KyBean obj){
		Ky_MoreBean.add(obj);
		}
	public int getArraySize(){
		return Ky_MoreBean.size();
	}

}
