USE [Dental Clinic Booking]
GO
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'ACEPT', N'ACEPT')
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'ACTIVE', N'ACTIVE')
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'CANCEL', N'CANCEL')
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'DEACTIVE', N'DEACTIVE')
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'DENY', N'DENY')
INSERT [dbo].[status] ([id], [status_name]) VALUES (N'DONE', N'DONE')
INSERT [dbo].[role] ([id], [role_name]) VALUES (N'ROLE_ADMIN', N'ROLE_ADMIN')
INSERT [dbo].[role] ([id], [role_name]) VALUES (N'ROLE_USER', N'ROLE_USER')
INSERT [dbo].[account] ([phone], [birthday], [email], [fullname], [password], [role_id], [status_id], [token]) VALUES (N'0143450789', N'02/12/2000', N'ccb@gmail.com', N'string', N'$2a$10$rWHuzZqOoBGMSXlTuNJYh.t/H0mungLlnEy/xRPT5m4Auy0FI7rYy', NULL, N'ACTIVE', NULL)
INSERT [dbo].[account] ([phone], [birthday], [email], [fullname], [password], [role_id], [status_id], [token]) VALUES (N'0906881041', N'02/12/2000', N'abc@gmail.com', N'Thanh Hiệp', N'$2a$10$1rK2ekBgYk40eF6tcwxuUuQBNsZ1zpMU7YZ6NjczG0SU.C5sVqeni', N'ROLE_USER', N'ACTIVE', N'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwOTA2ODgxMDQxIiwiaWF0IjoxNjI0NTk1NDQzLCJleHAiOjE2MjU0NTk0NDN9.2HqTEn8QFTjlW9yu7Kn-TAb0TZDzXaqlzUzIoH2RnIVosUwN4iDZfL01-GXsx2Yi1w0yvkywscbgqlGXnpPGrQ')
