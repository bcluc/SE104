-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 26, 2023 at 12:39 PM
-- Server version: 5.6.50
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flight_ticket_boooking_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `booking_user_id` varchar(255) NOT NULL,
  `booking_route_id` varchar(255) NOT NULL,
  `booking_date` varchar(255) NOT NULL,
  `booking_total_fare` varchar(255) NOT NULL,
  `booking_journey_date` varchar(255) NOT NULL,
  `booking_seat_type` varchar(255) NOT NULL,
  `booking_status` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `booking_user_id`, `booking_route_id`, `booking_date`, `booking_total_fare`, `booking_journey_date`, `booking_seat_type`, `booking_status`) VALUES
(1, '7', '4', '2019-03-05', '11250', '2019-03-16', 'Economy', '0'),
(2, '7', '3', '2019-03-05', '200', '2019-03-23', 'Economy', '0'),
(3, '7', '4', '2019-03-05', '8250', '2019-03-24', 'Economy', '0'),
(4, '7', '3', '2019-03-05', '1300', '2019-03-23', 'Economy', '0'),
(5, '7', '3', '2019-02-22', '200', '2019-02-23', 'Economy', '0'),
(6, '7', '3', '2021-02-22', '600', '2021-02-15', 'Economy', '0'),
(7, '7', '3', '2021-02-22', '900', '2021-02-14', 'Economy', '0'),
(8, '7', '4', '2021-02-22', '6375', '2021-02-26', 'Economy', '0'),
(9, '8', '4', '2023-04-18 23:01:43', '1700', '2023-3-21', 'Business', '0'),
(10, '8', '4', '2023-04-18 23:03:35', '1700', '2023-3-21', 'Business', '0'),
(11, '8', '4', '2023-04-18 23:06:50', '1700', '2023-3-21', 'Business', '0'),
(12, '8', '4', '2023-04-18 23:07:37', '1700', '2023-3-21', 'Business', '0'),
(13, '8', '4', '2023-04-18 23:07:59', '1700', '2023-3-21', 'Business', '0'),
(14, '8', '4', '2023-04-18 23:08:19', '1700', '2023-3-21', 'Business', '0'),
(16, '8', '6', '2023-04-18 23:30:36', '300', '2023-3-21', 'Business', '0'),
(17, '8', '4', '2023-04-19 00:27:41', '1700', '2021-3-30', 'Business', '0'),
(18, '20', '4', '2023-04-22 18:55:48', '1700', '2029-3-22', 'Business', '0'),
(19, '20', '4', '2023-04-29 15:08:10', '7500', '2027-3-29', 'Economy', '0'),
(20, '7', '4', '2023-04-29 15:25:12', '', '', '', '0'),
(21, '7', '4', '2023-06-26 16:55:04', '', '', '', '0'),
(22, '7', '4', '2023-06-26 17:06:46', '1500', '2023-5-26', 'Economy', '0');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(10) UNSIGNED NOT NULL,
  `city_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

    INSERT INTO `city` (`city_id`, `city_name`) VALUES
(1, N'Hà Nội'),
(2, N'Hải Phòng'),
(3, N'Thanh Hoá'),
(4, N'Vinh'),
(5, N'Đồng Hới'),
(6, N'Huế'),
(7, N'Đà Nẵng'),
(8, N'Quy Nhơn'),
(9, N'Nha Trang'),
(10, N'Tuy Hoà'),
(11, N'Buôn Ma Thuột'),
(12, N'Pleiku'),
(13, N'Đắk Lắk'),
(14, N'Tây Ninh'),
(15, N'TP. Hồ Chí Minh'),
(16, N'Cần Thơ'),
(17, N'Cà Mau');

-- --------------------------------------------------------

--
-- Table structure for table `coach_type`
--

CREATE TABLE `coach_type` (
  `ct_id` int(11) NOT NULL,
  `ct_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coach_type`
--

INSERT INTO `coach_type` (`ct_id`, `ct_name`) VALUES
(1, 'Sleeper'),
(2, 'Business');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `company_image` varchar(255) NOT NULL,
  `company_description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`company_id`, `company_name`, `company_image`, `company_description`) VALUES
(1, 'VietNam Airline', 'air-india-logo-156x156.gif', N'Hãng hàng không Vietnam Airlines được xem là hãng hàng không truyền thống chất lượng, dịch vụ tiện ích tuy nhiên mức giá khá cao.'),
(2, 'Vietjet Air ', 'untitled-1_287.png', N' Vietjet Air chính là hãng hàng không tư nhân đầu tiên tại Việt Nam.Vietjet Air hiện có hơn cả trăm chuyến bay trong và ngoài nước mỗi ngày. Giúp khách hàng dễ dàng chọn lựa được chuyến bay và thời gian phù hợp.'),
(3, 'Bamboo Airways', 'logo-af-app.png', N'Bamboo Airways thực hiện mô hình Hybrid được triển khai khá toàn diện từ các dịch vụ đặt vé, hành lý, ăn uống cho đến giải trí. Để bất cứ đối tượng khách hàng nào cũng tìm được sự thỏa mãn với những gói giá trị gia tăng phong phú và mức giá cạnh tranh.'),
(4, 'Vietravel Airline', 'Screen-shot-2013-03-17-at-11.27.43-PM.png', N'Vietravel Airlines thực hiện Hybrid mở bán vé đồng hạng với 17 mức giá từ thấp đến cao. Áp dụng 3 chính sách đặc biệt bao gồm hỗ trợ sai sót, hỗ trợ trùng booking và chính sách nhân ái.'),
(5, 'Pacific Airline', 'american.png', N'Pacific Airlines là hãng hàng không giá rẻ đầu tiên có trụ sở tại Sân bay Quốc tế Tân Sơn Nhất, Thành phố Hồ Chí Minh, Việt Nam. Với tiêu chí hoạt động là cung cấp vé máy bay giá rẻ mỗi ngày.'),
(6, 'Etihad vehicle', 'etihad.png', 'Etihad vehicle is the flag carrier airline of India headquartered at New Delhi.[8] It is owned by Air India Limited, a government-owned enterprise, and operates a fleet of Airbus and Boeing aircraft serving 94 domestic and international destinations.');

-- --------------------------------------------------------

--
-- Table structure for table `contactus`
--

CREATE TABLE `contactus` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `text` varchar(2000) NOT NULL,
  `adddate` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contactus`
--

INSERT INTO `contactus` (`id`, `userid`, `text`, `adddate`) VALUES
(1, 1, 'Hi, Please Reply to my question.', '2023-04-06 00:00:00'),
(2, 2, 'Hi', '2023-04-09 22:23:53'),
(3, 2, 'Hi app is good thanks for love', '2023-04-09 22:25:45'),
(4, 8, 'Great work', '2023-04-13 23:15:01'),
(5, 8, 'Test', '2023-04-19 00:27:58');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_name`) VALUES
(1, N'Việt Nam'),
(2, N'USA');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL,
  `login_user` varchar(255) NOT NULL,
  `login_password` varchar(255) NOT NULL,
  `login_level` varchar(255) NOT NULL,
  `login_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`login_id`, `login_user`, `login_password`, `login_level`, `login_date`) VALUES
(1, 'admin', 'test', '', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `month`
--

CREATE TABLE `month` (
  `month_id` int(11) NOT NULL,
  `month_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `month`
--

INSERT INTO `month` (`month_id`, `month_name`) VALUES
(1, 'January'),
(2, 'February'),
(3, 'March'),
(4, 'April'),
(5, 'May'),
(6, 'June'),
(7, 'July'),
(8, 'August'),
(9, 'September'),
(10, 'October'),
(11, 'November'),
(12, 'December');

-- --------------------------------------------------------

--
-- Table structure for table `passengar`
--

CREATE TABLE `passengar` (
  `passengar_id` int(11) NOT NULL,
  `passengar_booking_id` varchar(255) NOT NULL,
  `passengar_type` varchar(255) NOT NULL,
  `passengar_name` varchar(255) NOT NULL,
  `passengar_gender` varchar(255) NOT NULL,
  `passengar_age` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `passengar`
--

INSERT INTO `passengar` (`passengar_id`, `passengar_booking_id`, `passengar_type`, `passengar_name`, `passengar_gender`, `passengar_age`) VALUES
(41, '12', N'Người Lớn', N'Nguyễn Văn A', N'Nam', '35'),
(42, '13', N'Người lớn', N'Nguyễn Văn A', N'Nam', '35'),
(43, '14', N'Người lớn', N'Nguyễn Văn A', N'Nam', '35'),
(47, '16', N'Trẻ em', N'Nguyễn Văn An', N'Nam', '12'),
(48, '17', N'Người lớn', N'Test name', N'Nữ', '25'),
(49, '18', N'Người lớn', N'Nguyễn Thị B', N'Nữ', '23'),
(50, '19', N'Người lớn', N'Phan Lê Hoàng Kim', N'Nữ', '15'),
(51, '19', N'Trẻ em', N'Dương Tấn Hoàng', N'Nam', '12'),
(52, '19', N'Trẻ em', N'Kamisato Ayato', N'Nam', '12'),
(53, '19', N'Trẻ em', N'Đào Lan Anh', N'Nữ', '25'),
(54, '19', N'Trẻ em', N'Trần Văn Bê', N'Nam', '25'),
(55, '20', N'Người lớn', N'Ayaka', N'Nữ', '18'),
(56, '22', N'Người lớn', N'Kaushal Kishore', N'Nam', '35');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `cardnum` varchar(250) NOT NULL,
  `month` varchar(250) NOT NULL,
  `year` varchar(250) NOT NULL,
  `cvv` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `bookid`, `cardnum`, `month`, `year`, `cvv`) VALUES
(2, 16, '4236 5489 7378 7543', '02', '36', '362'),
(3, 17, '3612 4846 7379 7875', '02', '36', '365'),
(4, 18, '8888 8888 8888 8888', '02', '22', '122'),
(5, 19, '5888 8888 8888 8888', '02', '58', '888'),
(6, 22, '7865 7834 6587 3645', '07', '23', '343');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'Admin'),
(2, N'Khách hàng');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `route_vehicle_id` varchar(255) NOT NULL,
  `route_from_city` varchar(255) NOT NULL,
  `route_from_arrival` varchar(255) NOT NULL,
  `route_from_departure` varchar(255) NOT NULL,
  `route_to_city` varchar(255) NOT NULL,
  `route_economy_fare` varchar(255) NOT NULL,
  `route_business_fare` varchar(255) NOT NULL,
  `route_duration` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_id`, `route_vehicle_id`, `route_from_city`, `route_from_arrival`, `route_from_departure`, `route_to_city`, `route_economy_fare`, `route_business_fare`, `route_duration`) VALUES
(2, '2', '2', '12:00', '09:00', '12', '100', '150', '2h 35m'),
(3, '3', '2', '01:00 ', '03:45', '16', '200', '300', '1h 50m'),
(4, '2', '2', '03:20', '06:32', '16', '1500', '1700', '10h 15m'),
(5, '2', '11', '04:55', '06:45', '16', '600', '800', '4h 12m'),
(6, '5', '2', '12:10', '06:55', '10', '200', '300', '6h 10m'),
(7, '5', '10', '13:20 ', '13:40	', '11', '300', '400', '3h 10m'),
(8, '5', '11', '16:35', '16:45', '13', '400', '400', '1h 30m');

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`state_id`, `state_name`) VALUES
(1, 'UttarnPradesh'),
(2, 'Madhya Pradesh');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_banner`
--

CREATE TABLE `tbl_banner` (
  `id` int(11) NOT NULL,
  `image` varchar(500) NOT NULL,
  `p_id` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_banner`
--

INSERT INTO `tbl_banner` (`id`, `image`, `p_id`) VALUES
(2, '1.jpeg', 1),
(65, '2.jpeg', 2),
(66, '3.jpeg', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_level_id` varchar(255) DEFAULT '2',
  `user_username` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_add1` varchar(255) DEFAULT NULL,
  `user_add2` varchar(255) DEFAULT NULL,
  `user_city` varchar(255) DEFAULT NULL,
  `user_state` varchar(255) DEFAULT NULL,
  `user_country` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_mobile` varchar(255) DEFAULT NULL,
  `user_gender` varchar(255) DEFAULT NULL,
  `user_dob` varchar(255) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_level_id`, `user_username`, `user_password`, `user_name`, `user_add1`, `user_add2`, `user_city`, `user_state`, `user_country`, `user_email`, `user_mobile`, `user_gender`, `user_dob`, `user_image`) VALUES
(7, '2', 'customer', 'test', N'Trần Văn Thuận', N'187 Vo Thanh Trang street,', N'Quận Tân Bình', '2', '1', '1', 'amit@gmail.com', '9324324546', '', '26 December,2015', 'p1.jpg'),
(8, '2', 'suman', 'test', N'Nguyễn Văn A', N'9 Group 13, Cau Dien Townlet', N'Từ Điểm', '1', '2', '1', 'suman@gmail.com', '987654321', '', '13 January,1961', 'p2.jpg'),
(10, '2', 'manasa', 'test', N'Dương Tấn Hoàng', N'15I F3 Thai Thinh', N'Việt Nam', '2', '2', '1', 'manasa@gmail.com', '9876543212', '', '18 January,1968', 'p3.jpg'),
(16, '1', 'admin', 'test', N'Phan Lê Hoàng Kim', N'Floor 3, 12 Hoa Binh Street', N'An Cư', '1', '1', '1', 'kaushal.rahuljaiswal@gmail.com', '9567654565', '', '10-3-2016', 'Image.jpg'),
(19, '2', NULL, '000000', N'Test user', N'testaddress ', NULL, '6', NULL, NULL, 't@mail.com', '362598745', NULL, NULL, 't@mail.com.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL,
  `vehicle_company_id` varchar(255) NOT NULL,
  `vehicle_at_id` varchar(255) NOT NULL,
  `vehicle_name` varchar(255) NOT NULL,
  `vehicle_no` varchar(255) NOT NULL,
  `vehicle_from` varchar(255) NOT NULL,
  `vehicle_deaprture` varchar(255) NOT NULL,
  `vehicle_to` varchar(255) NOT NULL,
  `vehicle_arrival` varchar(255) NOT NULL,
  `vehicle_travel_time` varchar(255) NOT NULL,
  `vehicle_total_distance` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicle_id`, `vehicle_company_id`, `vehicle_at_id`, `vehicle_name`, `vehicle_no`, `vehicle_from`, `vehicle_deaprture`, `vehicle_to`, `vehicle_arrival`, `vehicle_travel_time`, `vehicle_total_distance`) VALUES
(2, '1', '2', 'VietNam Airline', 'AI-1563', '2', '12:20 AM', '16', '09:12 PM', '12 Hours', '1200 KM'),
(3, '2', '2', 'Vietjet Air', 'OA-9078', '2', '09:30 AM', '16', '10:45 PM', '07 Hours', '1200'),
(4, '3', '2', 'Bamboo Airways', 'FR-22104', '5', '07:40 AM', '1', '08:12 PM', '09 Hours', ''),
(5, '4', '2', 'Vietravel Airline', 'AC-12324', '2', '06:55 AM', '17', '03:00 AM', '26 Hours', '1462');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_type`
--

CREATE TABLE `vehicle_type` (
  `at_id` int(11) NOT NULL,
  `at_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `vehicle_type`
--

INSERT INTO `vehicle_type` (`at_id`, `at_name`) VALUES
(1, 'AC'),
(2, 'Non-AC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`);

--
-- Indexes for table `coach_type`
--
ALTER TABLE `coach_type`
  ADD PRIMARY KEY (`ct_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `contactus`
--
ALTER TABLE `contactus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login_id`);

--
-- Indexes for table `month`
--
ALTER TABLE `month`
  ADD PRIMARY KEY (`month_id`);

--
-- Indexes for table `passengar`
--
ALTER TABLE `passengar`
  ADD PRIMARY KEY (`passengar_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `tbl_banner`
--
ALTER TABLE `tbl_banner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicle_id`);

--
-- Indexes for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  ADD PRIMARY KEY (`at_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `city_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `coach_type`
--
ALTER TABLE `coach_type`
  MODIFY `ct_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `contactus`
--
ALTER TABLE `contactus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `month`
--
ALTER TABLE `month`
  MODIFY `month_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `passengar`
--
ALTER TABLE `passengar`
  MODIFY `passengar_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `state_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_banner`
--
ALTER TABLE `tbl_banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicle_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  MODIFY `at_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
