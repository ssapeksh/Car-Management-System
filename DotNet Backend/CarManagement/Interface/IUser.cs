using CarManagement.Models;

namespace CarManagement.Interface
{
    public interface IUser
    {
        public List<User> GetAllUsersDetails();  

        public User GetUserDetailById(int id);

        public void AddUser(User user);

        public void UpdateUser(User user);

        public void DeleteUser(int id);




    }
}
