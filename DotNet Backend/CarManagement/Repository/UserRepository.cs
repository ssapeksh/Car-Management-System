

using CarManagement.Data;
using CarManagement.Interface;
using CarManagement.Models;
using Microsoft.EntityFrameworkCore;

namespace CarManagement.Repository
{
    public class UserRepository : IUser
    {
        public readonly ApplicationDbContext _dbcontext;

        public UserRepository(ApplicationDbContext dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public List<User> GetAllUsersDetails()
        {

            try
            {
                return _dbcontext.Users.ToList();
            }
            catch
            {
                throw;
            }
        }

        public User GetUserDetailById(int id)
        {
            try
            {
                User? user = _dbcontext.Users.Find(id);
                if (user != null)
                {
                    return user;
                }
                else
                {
                    throw new ArgumentNullException();
                }

            }
            catch
            {
                throw;
            }
        }

        public void AddUser(User user)
        {
            try
            {
                _dbcontext.Users.Add(user);
                _dbcontext.SaveChanges();
            }
            catch
            {
                throw;
            }
        }

        public void UpdateUser(User user)
        {
            var existingUser = _dbcontext.Users.Local.FirstOrDefault(u => u.Id == user.Id);
            if (existingUser != null)
            {
                _dbcontext.Entry(existingUser).State = EntityState.Detached;
            }

            // Attach the updated entity and mark it as modified
            _dbcontext.Entry(user).State = EntityState.Modified;
            _dbcontext.SaveChanges();
        }

        public void DeleteUser(int id)
        {
            try
            {
                User? user = _dbcontext.Users.Find(id);
                if (user != null) 
                { 
                    _dbcontext.Users.Remove(user);
                    _dbcontext.SaveChanges();
                }
                else
                {
                    throw new ArgumentNullException();
                }
            }
            catch
            {
                throw ;
            }
        }
    }
}
