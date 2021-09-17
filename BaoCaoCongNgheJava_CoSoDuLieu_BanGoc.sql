CREATE DATABASE [DOAN_SPRING]

GO
USE [DOAN_SPRING]
GO

CREATE TABLE [Book]
(
	[Id] BIGINT IDENTITY(1,1) NOT NULL,
	[name] NVARCHAR(50) NOT NULL,
	[description] NVARCHAR(max),
	[categoryId] INT NOT NULL,
	[publishingHouseId] BIGINT NOT NULL,
	[views] BIGINT NOT NULL,
	[upvote] BIGINT NOT NULL,
	[downvote] BIGINT NOT NULL,
	[pdf] NVARCHAR(100),
	[img] NVARCHAR(100),

	CONSTRAINT PK_Book PRIMARY KEY ([Id])
)

CREATE TABLE [BookAuthor]
(
	[Id] BIGINT IDENTITY(1,1) NOT NULL,
	[name] NVARCHAR(50) NOT NULL,
	[description] NVARCHAR(max),
	[email] NVARCHAR(100),
	[address] NVARCHAR(100),

	CONSTRAINT PK_BookAuthor PRIMARY KEY ([Id])
)

CREATE TABLE [AuthorContribute]
(
	[bookAuthorId] BIGINT,
	[bookId] BIGINT,
	[role] NVARCHAR(50) NOT NULL,

	CONSTRAINT PK_AuthorContribute PRIMARY KEY ([bookAuthorId], [bookId])
)

CREATE TABLE [Category]
(
	[Id] INT IDENTITY(1,1) NOT NULL,
	[name] NVARCHAR(50) NOT NULL,
	[description] NVARCHAR(max),

	CONSTRAINT PK_Category PRIMARY KEY ([Id])
)

CREATE TABLE [PublishingHouse]
(
	[Id] BIGINT IDENTITY(1,1) NOT NULL,
	[name] NVARCHAR(50) NOT NULL,
	[description] NVARCHAR(max),
	[email] NVARCHAR(100),
	[address] NVARCHAR(100),

	CONSTRAINT PK_PublishingHouse PRIMARY KEY ([Id])
)

CREATE TABLE [Role]
(
	[Id] INT IDENTITY(1,1) NOT NULL,
	[name] NVARCHAR(50) NOT NULL,

	CONSTRAINT PK_Role PRIMARY KEY ([Id])
)

CREATE TABLE [User]
(
	[username] NVARCHAR(50) NOT NULL,
	[email] NVARCHAR(100) NOT NULL,
	[password] NVARCHAR(100) NOT NULL,
	[roleId] INT NOT NULL,

	CONSTRAINT PK_User PRIMARY KEY ([username])
)

ALTER TABLE [AuthorContribute]
ADD CONSTRAINT FK_AuthorContribute_Book FOREIGN KEY ([bookId]) REFERENCES [Book]([Id])

ALTER TABLE [AuthorContribute]
ADD CONSTRAINT FK_AuthorContribute_BookAuthor FOREIGN KEY ([bookAuthorId]) REFERENCES [BookAuthor]([Id])

ALTER TABLE [Book]
ADD CONSTRAINT FK_Book_Category FOREIGN KEY ([categoryId]) REFERENCES [Category]([Id])

ALTER TABLE [Book]
ADD CONSTRAINT FK_Book_PublishingHouse FOREIGN KEY ([publishingHouseId]) REFERENCES [PublishingHouse]([Id])

ALTER TABLE [User]
ADD CONSTRAINT FK_User_Role FOREIGN KEY ([roleId]) REFERENCES [Role]([Id])