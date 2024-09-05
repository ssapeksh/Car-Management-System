using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace CarManagement.Models
{
    [Table("Roles")]
    public class Role
    {
        [Key]
        [Column("RoleId")]
        public int RoleId { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string RoleName { get; set; }
    }


}
