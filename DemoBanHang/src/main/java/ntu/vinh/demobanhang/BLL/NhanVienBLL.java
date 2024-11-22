package ntu.vinh.demobanhang.BLL;

import ntu.vinh.demobanhang.DAL.NhanVienDAL;
import ntu.vinh.demobanhang.Model_DTO.NhanVien;

public class NhanVienBLL {
  NhanVienDAL nvDAL;
  public boolean ThemMoi (NhanVien nv){
    boolean kq =  nvDAL.AddNew(nv);
    return kq;
  }

  public boolean checkLogin(String id, String matkhau){
    return nvDAL.Login(id, matkhau);
  }
}
