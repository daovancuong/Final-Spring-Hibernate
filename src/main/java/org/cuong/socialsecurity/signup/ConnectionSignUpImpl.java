//package org.cuong.socialsecurity.signup;
//
//import org.cuong.dao.MyUserAccountDAO;
//import org.cuong.model.MyUserAccount;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionSignUp;
//
//public class ConnectionSignUpImpl implements ConnectionSignUp {
//
//  private MyUserAccountDAO myUserAccountDAO;
//
//  public ConnectionSignUpImpl(MyUserAccountDAO myUserAccountDAO) {
//      this.myUserAccountDAO = myUserAccountDAO;
//  }
//
// 
//  // Sau khi đăng nhập mạng xã hội xong.
//  // Phương thức này sẽ được gọi để tạo ra một bản ghi User_Account tương ứng
//  // nếu nó chưa tồn tại.
//  public String execute(Connection<?> connection) {
//     
//
//      MyUserAccount account=    myUserAccountDAO.createUserAccount(connection);
//      return account.getId();
//  }
//
//}
