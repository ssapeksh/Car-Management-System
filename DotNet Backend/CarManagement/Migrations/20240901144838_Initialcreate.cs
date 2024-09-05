using System;
using Microsoft.EntityFrameworkCore.Migrations;
using MySql.EntityFrameworkCore.Metadata;

#nullable disable

namespace CarManagement.Migrations
{
    /// <inheritdoc />
    public partial class Initialcreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "car_details",
                columns: table => new
                {
                    car_id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    CarName = table.Column<string>(type: "varchar(255)", nullable: false),
                    CarModel = table.Column<string>(type: "varchar(255)", nullable: false),
                    Brand = table.Column<string>(type: "varchar(255)", nullable: false),
                    Price = table.Column<double>(type: "double", nullable: false),
                    Available = table.Column<bool>(type: "tinyint(1)", nullable: false),
                    Status = table.Column<string>(type: "varchar(255)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_car_details", x => x.car_id);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Roles",
                columns: table => new
                {
                    RoleId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    RoleName = table.Column<string>(type: "varchar(255)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Roles", x => x.RoleId);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "user_details",
                columns: table => new
                {
                    User_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    User_Name = table.Column<string>(type: "varchar(255)", nullable: false),
                    User_Age = table.Column<int>(type: "int", nullable: false),
                    Email = table.Column<string>(type: "varchar(255)", nullable: false),
                    Password = table.Column<string>(type: "varchar(255)", nullable: false),
                    Status = table.Column<string>(type: "varchar(255)", nullable: false),
                    City = table.Column<string>(type: "varchar(255)", nullable: false),
                    Role = table.Column<string>(type: "varchar(255)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_user_details", x => x.User_Id);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "order_details",
                columns: table => new
                {
                    OrderId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    OrderDate = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    Duration = table.Column<int>(type: "int", nullable: false),
                    userId = table.Column<int>(type: "int", nullable: false),
                    carId = table.Column<int>(type: "int", nullable: false),
                    OrderStatus = table.Column<string>(type: "varchar(255)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_order_details", x => x.OrderId);
                    table.ForeignKey(
                        name: "FK_order_details_car_details_carId",
                        column: x => x.carId,
                        principalTable: "car_details",
                        principalColumn: "car_id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_order_details_user_details_userId",
                        column: x => x.userId,
                        principalTable: "user_details",
                        principalColumn: "User_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_order_details_carId",
                table: "order_details",
                column: "carId");

            migrationBuilder.CreateIndex(
                name: "IX_order_details_userId",
                table: "order_details",
                column: "userId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "order_details");

            migrationBuilder.DropTable(
                name: "Roles");

            migrationBuilder.DropTable(
                name: "car_details");

            migrationBuilder.DropTable(
                name: "user_details");
        }
    }
}
