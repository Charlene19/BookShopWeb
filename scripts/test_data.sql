/*==============================================================*/
/*				TEST DATA  for BookShop							*/
/*			Date de création :  01/10/2020 16:49:00             */
/*==============================================================*/

-- Resets auto-increment
DBCC CHECKIDENT('EVENT', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('AUTHOR', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PUBLISHER', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('BOOK_STATUS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('COMMENT_STATUS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PACKAGE_STATUS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PAYMENT_STATUS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('CARRIER_STATUS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('SHIPPING_OFFER', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('KEYWORD', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('CATEGORY', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('VAT', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PACKAGE', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('CUSTOMER', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('ORDER', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('ADDRESS', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('CARRIER', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('EMPLOYEE', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PAYMENT_ORGANIZATION', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('CARD_TYPE', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('ORDER_ROW', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('COMMENT', RESEED, 0) WITH NO_INFOMSGS
DBCC CHECKIDENT('PAYMENT', RESEED, 0) WITH NO_INFOMSGS

-- Clears all previous data
DELETE FROM ASSOC_ADDRESS_PUBLISHER;
DELETE FROM ASSOC_CATEGORY_CATEGORY;
DELETE FROM ASSOC_BOOK_AUTHOR;
DELETE FROM ASSOC_BOOK_KEYWORD;
DELETE FROM ASSOC_BOOK_EVENT;
DELETE FROM ASSOC_BOOK_CATEGORY;
DELETE FROM ASSOC_STATUS_BOOK;
DELETE FROM ASSOC_STATUS_PACKAGE;
DELETE FROM ASSOC_STATUS_CUSTOMER;
DELETE FROM ASSOC_CUSTOMER_DELIVERY_ADDRESS;
DELETE FROM ASSOC_CUSTOMER_BILLING_ADDRESS;
DELETE FROM ASSOC_COMMENT_EMPLOYEE;
DELETE FROM ASSOC_GROUP_EMPLOYEE;
DELETE FROM ASSOC_ORDER_PACKAGE;
DELETE FROM ASSOC_PERMISSION_GROUP;
DELETE FROM ASSOC_STATUS_CARRIER;
DELETE FROM ASSOC_STATUS_COMMENT;
DELETE FROM ASSOC_STATUS_ORDER;
DELETE FROM ASSOC_STATUS_PAYMENT;

DELETE FROM COMMENT;
DELETE FROM COMMENT_STATUS;

DELETE FROM ORDER_ROW;

DELETE FROM ATTRIBUTE;
DELETE FROM BOOK;
DELETE FROM CATEGORY;
DELETE FROM KEYWORD;
DELETE FROM BOOK_STATUS;
DELETE FROM PUBLISHER;
DELETE FROM [EVENT];
DELETE FROM VAT;
DELETE FROM AUTHOR;

DELETE FROM PACKAGE;
DELETE FROM PACKAGE_STATUS;

DELETE FROM PAYMENT;
DELETE FROM PAYMENT_STATUS;
DELETE FROM CARD_TYPE;
DELETE FROM PAYMENT_ORGANIZATION;

DELETE FROM [ORDER];
DELETE FROM ORDER_STATUS;

DELETE FROM SHIPPING_OFFER;
DELETE FROM CARRIER;
DELETE FROM CARRIER_STATUS;

DELETE FROM CUSTOMER;
DELETE FROM CUSTOMER_STATUS;

DELETE FROM EMPLOYEE;
DELETE FROM [GROUP];
DELETE FROM PERMISSION;

DELETE FROM [ADDRESS];

-- SELF-EXPL
SET DATEFORMAT ymd;


-- TESTDATA START --
INSERT INTO CATEGORY 
	(CATEGORY_NAME) 
	values 
	    ('categories'),
		
		('categorie_A'),
		('categorie_B'),
		('categorie_C'),
		
		('categorie_A_0'),
		('categorie_A_1'),
		('categorie_A_2'),
		
		('categorie_B_0'),
		('categorie_B_1'),
		('categorie_B_2')
;

INSERT INTO ASSOC_CATEGORY_CATEGORY
	(CATEGORY_PARENT_ID, CATEGORY_CHILD_ID)
	values
		(1, 2),
		(1, 3),
		(1, 4),
		(2, 5),
		(2, 6),
		(2, 7),
		(3, 8),
		(3, 9),
		(3, 10)
;

INSERT INTO KEYWORD (KEYWORD_NAME) values 
('roman'),
('théâtre'),
('manga'),
('informatique'),
('programmation'),
('historique'),
('antiquité'),
('moyen-âge'),
('XXe siècle'),
('XIXe siècle'),
('aventure'),
('jeunesse'),
('philosophie'),
('histoire'),
('manga'),
('shonen'),
('BD'),
('comédie'),
('tragédie'),
('chevalerie'),
('classique'),
('poésie'),
('psychanalyse');

INSERT INTO BOOK_STATUS
	(BOOK_STATUS_NAME) 
	values 
		('statut_livre_0'),
		('statut_livre_1'),
		('statut_livre_2')
;

INSERT INTO PUBLISHER (PUBLISHER_NAME, PUBLISHER_POST_IT) values
('Folio', ''),
('Livre de Poche', ''),
('GF', ''),
('Gallimard', ''),
('Seuil', ''),
('Glénat', ''),
('Casterman', ''),
('Hachette', ''),
('Eyrolles', ''),
('Editions ENI', '');

INSERT INTO AUTHOR (AUTHOR_L_NAME, AUTHOR_F_NAME, AUTHOR_POST_IT) values
('Orwell', 'Georges', ''),
('Anouilh', 'Jean', ''),
('Jean de La Fontaine', 'Jean de', ''),
('Marivaux', '', ''),
('Verlaine', 'Paul', ''),
('Musset', 'Alfred de', ''),
('Hugo', 'Victor', ''),
('Cervantes', 'Miguel de', ''),
('Dante', '', ''),
('Thucydide', '', ''),
('Tacite', '', ''),
('Toriyama', 'Akira', ''),
('Hergé', '', ''),
('Freud', 'Sigmund', ''),
('Aristote', '', ''),
('Platon', '', ''),
('Pennac', 'Daniel', ''),
('Marchand Kalicky', 'Anne', ''),
('Delannoy', 'Claude', ''),
('Herby', 'Cyrille', ''),
('Gervais', 'Luc', '');


INSERT INTO VAT
	(VAT_RATE)
	values
		(5.50),
		(12.80),
		(20.00)
;

INSERT INTO [EVENT]
	(EVENT_NAME, EVENT_DATE_START, EVENT_DATE_END, EVENT_DISCOUNT_VALUE, EVENT_IMAGE_URL)
	values
		('evenement_0', '01/01/2001', '01/01/2001', 10.00, null),
		('evenement_1', '01/01/2001', '01/01/2001', 50.00, null),
		('evenement_2', '01/01/2001', '01/01/2001', 70.00, null)
;

INSERT INTO BOOK
	(BOOK_ISBN, PUBLISHER_ID, VAT_ID, BOOK_TITLE, BOOK_SUBTITLE, BOOK_HT_PRICE, BOOK_COVER_URL, BOOK_SUMMARY, BOOK_STOCK_QTY, BOOK_SHELF, BOOK_POST_IT)
	values


/* Littérature */
('9782072878497', 1, 3, '1984', '', 8.5, 'img\1984.jpg', 'Le roman contre-utopique du XXe siècle', 14, 'rayon A', ''),
('9782710381419', 1, 3, 'Antigone', '', 6.1, 'img\antigone.jpg', 'Adaptation du célèbre personnage de la mythologie au contexte du XXe siècle', 58, 'rayon A', ''),
('9782070375165', 1, 3, 'La ferme des animaux', '', 6.3, 'img\laferme.jpg', '', 2, 'rayon L', ''),
('9782253010043', 2, 3, 'Les fables de La Fontaine', '', 3.1, 'img\fontaine.jpg', '', 30, 'rayon L', ''),
('9782081516342', 3, 3, 'Les fausses confidences', '', 2.8, 'img\confidences.jpg', '', 5, 'rayon L', ''),
('9782070320530', 4, 3, 'Fêtes Galantes', '', 6.2, 'img\galantes.jpg', '', 56, 'rayon L', ''),
('9782253161080', 2, 3, 'La confession d''un enfant du siècle', '', 6.5, 'img\confidences.jpg', '', 12, 'rayon L', ''),
('9782010008993', 2, 3, 'Les Misérables', '', 4.75, 'img\miserables.jpg', 'Le plus fameux roman de Victor Hugo, qui nous plonge dans les misères du peuple parisien dans les décennies suivant la Révolution.', 84, 'rayon L', ''),
('9782070406029', 4, 3, 'Les Châtiments', '', 7.5, 'img\chatiments.jpg', 'Le recueil de poèmes de Victor Hugo, opposant politique féroce à Napoléon III.', 2, 'rayon L', ''),
('9782253160786', 2, 3, 'Quatrevingt-Treize', '', 5.7, 'img\93.jpg', '', 26, 'rayon Q', ''),
('9782020222129', 5, 3, 'Don Quichotte de la Manche', '', 8.8, 'img\donQuich.jpg', '', 51, 'rayon D', ''),
('9782080712165', 3, 3, 'Divine Comédie', 'L''Enfer', 10.00, 'img\divine.jpg', '', 3, 'Rayon D', ''),

/* Sciences humaines */
('9782070400683', 1, 3, 'La Guerre du Péloponnèse', '', 13.5, 'img\1.jpg', '', 18, 'Rayon L', ''),
('9782070387625', 1, 3, 'Annales', '', 9.9, 'img\2.jpg', '', 3, 'rayon A', ''),
('9782757802137', 5, 3, 'L''interprétation du rêve', '', 13.5, 'img\3.jpg', '', 2, 'Rayon L', ''),
('9782081358775', 3, 3, 'Politiques', '', 10.0, 'img\4.jpg', '', 5, 'Rayon P', ''),
('9782080705631', 3, 3, 'Métaphysique', '', 11.5, 'img\5.jpg', '', 2, 'Rayon M', ''),
('9782081421547', 3, 3, 'De l''Âme', '', 8.1, 'img\6.jpg', '', 2, 'Rayon M', ''),
('9782081386693', 3, 3, 'République', '', 8.9, 'img\7.jpg', '', 8, 'Rayon R', ''),
('9782081427730', 3, 3, 'Gorgias', '', 5.2, 'img\8.jpg', '', 8, 'Rayon G', ''),
('9782080704894', 3, 3, 'Phédon', '', 8.2, 'img\9.jpg', '', 4, 'Rayon P', ''),
('9782081377226', 3, 3, 'Apologie de Socrate', '', 3.5, 'img\10.jpg', '', 7, 'Rayon A', ''),
('9782081422582', 3, 3, 'Banquet', '', 4.0, 'img\11.jpg', '', 27, 'Rayon B', ''),
('9782080706881', 3, 3, 'Parménide', '', 8.8, 'img\12.jpg', '', 4, 'Rayon P', ''),

/* BD / Manga */
('9782876952058', 6, 3, 'Dragon Ball', 'Tome 1', 6.9, 'img\13.jpg', '', 2, 'rayon D', ''),
('9782876952065', 6, 3, 'Dragon Ball', 'Tome 2', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952072', 6, 3, 'Dragon Ball', 'Tome 3', 6.9, 'img\13.jpg', '', 8, 'rayon D', ''),
('9782876952102', 6, 3, 'Dragon Ball', 'Tome 4', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952119', 6, 3, 'Dragon Ball', 'Tome 5', 6.9, 'img\13.jpg', '', 11, 'rayon D', ''),
('9782876952126', 6, 3, 'Dragon Ball', 'Tome 6', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952171', 6, 3, 'Dragon Ball', 'Tome 7', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952188', 6, 3, 'Dragon Ball', 'Tome 8', 6.9, 'img\13.jpg', '', 14, 'rayon D', ''),
('9782876952195', 6, 3, 'Dragon Ball', 'Tome 9', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952201', 6, 3, 'Dragon Ball', 'Tome 10', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782876952218', 6, 3, 'Dragon Ball', 'Tome 11', 6.9, 'img\13.jpg', '', 31, 'rayon D', ''),
('9782723418553', 6, 3, 'Dragon Ball', 'Tome 12', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782723418560', 6, 3, 'Dragon Ball', 'Tome 13', 6.9, 'img\13.jpg', '', 7, 'rayon D', ''),
('9782723418577', 6, 3, 'Dragon Ball', 'Tome 14', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782723418584', 6, 3, 'Dragon Ball', 'Tome 15', 6.9, 'img\13.jpg', '', 1, 'rayon D', ''),
('9782203198920', 7, 3, 'Les Aventures de Tintin', 'Intégrale : Coffret en 8 volumes', 90.0, 'img\14.jpg', '', 5, 'rayon L', ''),
('9782203001114', 7, 3, 'Les Aventures de Tintin', 'Le Trésor de Rackham le Rouge', 11.5, 'img\14.jpg', '', 5, 'rayon L', ''),
('9782203001152', 7, 3, 'Les Aventures de Tintin', 'Objectif Lune', 11.5, 'img\14.jpg', '', 5, 'rayon L', ''),
('9782203001169', 7, 3, 'Les Aventures de Tintin', 'On a marché sur la Lune', 11.5, 'img\14.jpg', '', 4, 'rayon L', ''),
('9782203001107', 7, 3, 'Les Aventures de Tintin', 'Le Secret de la Licorne', 11.5, 'img\14.jpg', '', 2, 'rayon L', ''),
('9782203001121', 7, 3, 'Les Aventures de Tintin', 'Les sept boules de cristal', 11.5, 'img\14.jpg', '', 2, 'rayon L', ''),
('9782203001183', 7, 3, 'Les Aventures de Tintin', 'Coke en stock', 11.5, 'img\14.jpg', '', 3, 'rayon L', ''),

/* Jeunesse */
('9782075109178', 1, 3, 'Une aventure de Kamo', '1. - L''idée du siècle', 5.9, 'img\15.jpg', '', 8, 'Rayon U', ''),
('9782075090858', 1, 3, 'Une aventure de Kamo', '2. - Kamo et moi', 5.9, 'img\15.jpg', '', 5, 'Rayon U', ''),
('9782075109222', 1, 3, 'Une aventure de Kamo', '3. - L''agence Babel', 5.9, 'img\15.jpg', '', 3, 'Rayon U', ''),
('9782075090841', 1, 3, 'Une aventure de Kamo', '4. - L''évasion de Kamo', 5.9, 'img\15.jpg', '', 14, 'Rayon U', ''),
('9782012202894', 8, 3, 'Oui-Oui joue au football', '', 1.75, 'img\15.jpg', '', 25, 'Rayon O', ''),
('9782012274495', 8, 3, 'Oui-Oui et la fête de la musique', '', 1.75, 'img\15.jpg', '', 25, 'Rayon O', ''),
('9782012275973', 8, 3, 'Oui-Oui et la fête de Miniville', '', 1.75, 'img\15.jpg', '', 52, 'Rayon O', ''),

/* Autres */
('9782416000188', 9, 3, 'Programmer en Java', 'Couvre Java 10 à Java 14', 35.00, 'img\16.jpg', '', 13, 'Rayon P', ''),
('9782212675214', 9, 3, 'Apprenez à programmer en Java', '', 35.0, 'img\16.jpg', '', 54, 'Rayon A', ''),
('9782409026300', 10, 3, 'Apprendre la Programmation Orientée Objet avec le langage Java', '', 28.0, 'img\16.jpg', '', 12, 'Rayon A', '');

INSERT INTO ASSOC_BOOK_AUTHOR
	(AUTHOR_ID, BOOK_ISBN)
	values
/* 12 en littérature */
		(1, '9782072878497'),
		(2, '9782710381419'),
		(1, '9782070375165'),
		(3, '9782253010043'),
		(4, '9782081516342'),
		(5, '9782070320530'),
		(6 ,'9782253161080'),
		(7, '9782010008993'),
		(7, '9782070406029'),
		(7, '9782253160786'),
		(8, '9782020222129'),
		(9, '9782080712165'),
/* 12 en sciences humaines */
		(10, '9782070400683'),
		(11, '9782070387625'),
		(14, '9782757802137'),
		(15, '9782081358775'),
		(15, '9782080705631'),
		(15, '9782081421547'),
		(16, '9782081386693'),
		(16, '9782081427730'),
		(16, '9782080704894'),
		(16, '9782081377226'),
		(16, '9782081422582'),
		(16, '9782080706881'),
/* 22 en BD/Manga */
		(12, '9782876952058'),
		(12, '9782876952065'),
		(12, '9782876952072'),
		(12, '9782876952102'),
		(12, '9782876952119'),
		(12, '9782876952126'),
		(12, '9782876952171'),
		(12, '9782876952188'),
		(12, '9782876952195'),
		(12, '9782876952201'),
		(12, '9782876952218'),
		(12, '9782723418553'),
		(12, '9782723418560'),
		(12, '9782723418577'),
		(12, '9782723418584'),
		(13, '9782203198920'),
		(13, '9782203001114'),
		(13, '9782203001152'),
		(13, '9782203001169'),
		(13, '9782203001107'),
		(13, '9782203001121'),
		(13, '9782203001183'),
/* 7 dans jeunesse */
		(17, '9782075109178'),
		(17, '9782075090858'),
		(17, '9782075109222'),
		(17, '9782075090841'),
		(18, '9782012202894'),
		(18, '9782012274495'),
		(18, '9782012275973'),
/* 3 dans autres */
		(19, '9782416000188'),
		(20, '9782212675214'),
		(21, '9782409026300')
;

INSERT INTO ASSOC_BOOK_EVENT
	(EVENT_ID, BOOK_ISBN)
	values
		(1, '9782203001107'),
		(2, '9782203001107'),
		(3, '9782203001107'),
		(1, '9782409026300'),
		(2, '9782409026300'),
		(3, '9782409026300')
;

INSERT INTO [dbo].[ASSOC_BOOK_KEYWORD]
           ([KEYWORD_ID]
           ,[BOOK_ISBN])
	values
		(1, '9782072878497'),
		(2, '9782710381419'),
		(1, '9782070375165'),
		(21, '9782253010043'),
		(2, '9782081516342'),
		(22, '9782070320530'),
		(10 ,'9782253161080'),
		(1, '9782010008993'),
		(1, '9782070406029'),
		(1, '9782253160786'),
		(21, '9782020222129'),
		(21, '9782080712165'),
		(7, '9782070400683'),
		(7, '9782070387625'),
		(23, '9782757802137'),
		(13, '9782081358775'),
		(13, '9782080705631'),
		(13, '9782081421547'),
		(13, '9782081386693'),
		(13, '9782081427730'),
		(13, '9782080704894'),
		(13, '9782081377226'),
		(13, '9782081422582'),
		(13, '9782080706881'),
		(16, '9782876952058'),
		(16, '9782876952065'),
		(16, '9782876952072'),
		(16, '9782876952102'),
		(16, '9782876952119'),
		(16, '9782876952126'),
		(16, '9782876952171'),
		(16, '9782876952188'),
		(16, '9782876952195'),
		(16, '9782876952201'),
		(16, '9782876952218'),
		(16, '9782723418553'),
		(16, '9782723418560'),
		(16, '9782723418577'),
		(16, '9782723418584'),
		(17, '9782203198920'),
		(17, '9782203001114'),
		(17, '9782203001152'),
		(17, '9782203001169'),
		(17, '9782203001107'),
		(17, '9782203001121'),
		(17, '9782203001183'),
		(12, '9782075109178'),
		(12, '9782075090858'),
		(12, '9782075109222'),
		(12, '9782075090841'),
		(12, '9782012202894'),
		(12, '9782012274495'),
		(12, '9782012275973'),
		(5, '9782416000188'),
		(5, '9782212675214'),
		(5, '9782409026300'),
		(4, '9782416000188'),
		(4, '9782212675214'),
		(4, '9782409026300')
;

INSERT INTO ASSOC_BOOK_CATEGORY
	(BOOK_ISBN, CATEGORY_ID)
	values
		('9782012274495', 5),
		('9782723418560', 6),
		('9782012274495', 6),
		('9782012274495', 8),
		('9782723418560', 9)
;

INSERT INTO ASSOC_STATUS_BOOK
	(BOOK_ISBN, BOOK_STATUS_ID)
	values
		('9782012274495', 1),
		('9782876952065', 1),
		('9782723418560', 2),
		('9782070406029', 3),
		('9782070400683', 1)
;

INSERT INTO [ADDRESS]
	([ADDRESS_L_NAME],[ADDRESS_F_NAME],[ADDRESS_STREET],[ADDRESS_STREET_EXTRA],[ADDRESS_POSTCODE],[ADDRESS_CITY],[ADDRESS_PHONE],[ADDRESS_PHONE_EXTRA]) 
	VALUES
		('Guthrie','May','657-9768 Cras Rd.','Ap #529-6758 Convallis, Rd.','44843','Dawson Creek','08 32 92 33 86','04 91 26 63 90'),
		('Walton','Hayley','613-6139 Cum Rd.','Ap #685-903 Ridiculus St.','17599','La Magdeleine','01 38 41 63 73','07 83 23 15 61'),
		('Copeland','Aurora','P.O. Box 624, 5187 Tortor, Ave','Ap #464-4705 Ullamcorper Street','21886','Grande Prairie','04 15 81 86 23','09 15 57 50 96'),
		('Hammond','Zoe','Ap #278-3627 Risus. St.','Ap #838-8990 Sodales. Av.','78355','Friedrichshafen','09 11 86 94 01','01 87 56 74 61'),
		('Hernandez','Sybill','853-9812 Sed Rd.','P.O. Box 561, 662 Sed Avenue','19487','Armidale','03 87 09 37 94','01 17 32 77 03'),
		('Contreras','Audrey','700-468 Hendrerit Street','364-8252 Nulla Street','52351','Hualaihué','01 52 91 95 24','04 16 74 36 56'),
		('Torres','Oprah','698-3420 Vivamus Ave','P.O. Box 695, 2454 Felis St.','32877','Lugnano in Teverina','03 50 94 67 49','07 68 38 01 97'),
		('Jordan','Illiana','2844 Nascetur Ave','P.O. Box 395, 3046 Egestas Avenue','76235','Koersel','08 41 17 16 27','06 57 39 98 16'),
		('Kirkland','Fleur','127 Vivamus St.','419-6051 Luctus Av.','30215','Anghiari','03 76 35 02 12','06 44 00 79 16'),
		('Atkins','Jessica','P.O. Box 815, 5575 Gravida. St.','Ap #438-9898 Mauris Rd.','25758','Chichester','06 07 96 66 31','02 96 52 21 75')
;

INSERT INTO CUSTOMER_STATUS
	([CUSTOMER_STATUS_ID],[CUSTOMER_STATUS_NAME],[STATUT_CLIENT_DATE_DEB],[CUSTOMER_STATUS_POST_IT])
     VALUES
		(17 ,'Valide' ,'2014-05-23T14:25:10' ,'ras'),
		(8 ,'En attente' ,'2013-05-23T14:25:10' ,'ras'), 
		(3,'Rejete' ,'2012-05-23T14:25:10' ,'ras'),
		(6 ,'Valide' ,'2011-04-23T14:25:10' ,'ras'), 
		(2 ,'Rejete' ,'2020-05-23T14:25:10' ,'Indesirable'), 
		(5 ,'En attente' ,'2020-05-23T14:25:10' ,'Verifier')
;

INSERT INTO CUSTOMER
	([CUSTOMER_L_NAME],[CUSTOMER_F_NAME],[CUSTOMER_EMAIL],[CUSTOMER_USERNAME],[CUSTOMER_PASSWORD],[CUSTOMER_POST_IT]) 
	VALUES
		('Nom10','Prenom50','ultrices.Duis.volutpat@venenatislacusEtiam.co.uk','membre1','2002','volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus'), 
		('Nom1050','Prenom560','enim@mauris.com','2membre','35690','rutrum magna. Cras convallis convallis dolor. Quisque tincidunt'), 
		('Nom1060','Prenom600','elit.Etiam@sitamet.net','20','20','orci. Ut semper pretium neque. Morbi quis urna.'),
		('Nom2050','Prenom75','metus@eu.org','user20','1220','risus. Nulla eget metus eu erat semper rutrum.'), 
		('Nom30','Prenom97','eu.augue.porttitor@Fuscediam.edu','dude20','23sol0','enim, condimentum eget, volutpat ornare, facilisis eget, ipsum.'),
		('Nom70','Prenom9750','Proin@et.co.uk','user300','2130','semper tellus id nunc interdum feugiat. Sed nec'), 
		('Nom7050','Prenom960','tincidunt@aliquet.ca','face20','22590','laoreet, libero et tristique pellentesque, tellus sem mollis'),
		('Nom20','Prenom750','sodales.at@sed.ca','user40','4210','condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec'),
		('Nom2040','Prenom87','a@Maecenasliberoest.com','user5','21230','auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus.')
;

INSERT INTO ASSOC_STATUS_CUSTOMER
	([CUSTOMER_ID] ,[CUSTOMER_STATUS_ID] ,[ASSOC_STATUS_CLIENT_DATE] ,[ASSOC_STATUS_CLIENT_POST_IT])
	VALUES
		(1 ,17 ,'2018-05-23T14:25:10' ,'ras'),
		(4 ,8 ,'2019-05-23T14:25:10' ,'ras'),
		(5 ,3 ,'2014-05-23T14:25:10' ,'ras'),
		(6 ,6 ,'2017-05-23T14:25:10' ,'ras'),
		(7 ,2 ,'2020-05-23T14:25:10' ,'ras')
;

insert into PACKAGE_STATUS 
	(PACKAGE_STATUS_NAME)
	values 
		('Pris en charge par le transporteur'),
		('Arrivé sur le site de tri'),
		('Arrivé sur le site de distribution'),
		('En cours de livraison'),
		('Livré'),
		('Livraison reportée'),
		('Colis perdu')
;

insert into CARRIER_STATUS 
	(CARRIER_STATUS_NAME, CARRIER_STATUS_POST_IT)
	values	
		('Actif', null),
		('Inactif', 'Si contrat non reconduit'),
		('Litigieux', 'Litige en cours, à surveiller'),
		('Invalide', 'Si le transporteur a cessé d exister'),
		('Banni', 'Si on ne souhaite plus travailler avec un transporteur à cause d un litige')
;

insert into CARRIER 
	(ADDRESS_ID, CARRIER_CORPORATE_NAME, CARRIER_EMAIL)
	values	
		('7', 'La Poste', 'contactpro@laposte.net'),
		('5', 'DHL', 'dhldeliveryservice@dhl.com'),
		('6', 'UPS', 'ups@ups.com'),
		('5', 'TNT', 'contact@tnt.com')
;

insert into PACKAGE 
	(PACKAGE_TRACKING_NUMBER, PACKAGE_SHIPPING_DATE, PACKAGE_POST_IT)
	values	
		('Fesge32254343823', '2018-05-23T14:25:10', null),
		('Rdf5225d526s4646', '2018-05-23T14:25:10', null),
		('gf55s5s522z84eftt', '2018-05-23T14:25:10', '2e envoi suite à colis égaré (envoi du 19-6-2019)'),
		('5f5df2zerf5a2zrefa', '2018-05-23T14:25:10', null),
		('dz2aerg8a2erger8ga2', '2018-05-23T14:25:10', null),
		('rezagerg628846gaer', '2018-05-23T14:25:10', null),
		('er5g5ze2g2zeg2ze82', '2018-05-23T14:25:10', null),
		('zn514advbnkjj15422', '2018-05-23T14:25:10', null),
		('fg2298gf628z6gaze88', '2018-05-23T14:25:10', null),
		('1fef6r82gaz2er2ga6g', '2018-05-23T14:25:10', null),
		('d82282erg26z626rg26', '2018-05-23T14:25:10', null),
		('82af2r2a22r82ga2er2g', '2018-05-23T14:25:10', null),
		('7f9a8f2f2re2g8r2g6a8', '2018-05-23T14:25:10', null),
		('rge684g2z26e8r2gz26g', '2018-05-23T14:25:10', null),
		('gz49zg82ga26er8g2a26', '2018-05-23T14:25:10', null),
		('f348223q324f3are2ggr', '2018-05-23T14:25:10', null)
;

insert into SHIPPING_OFFER
	(CARRIER_ID, SHIPPING_OFFER_NAME, SHIPPING_OFFER_DETAILS, SHIPPING_OFFER_CONDITIONS, SHIPPING_OFFER_HT_PRICE, SHIPPING_OFFER_POST_IT)
	values	
		(1, 'Lettre suivie', 'Livré sous 5 jours ouvrés, n° de suivi disponible', 'Livraison en boîte aux lettres', 2.45, null),
		(1,'Colissimo', 'Livré sous 3 jours ouvrés, n° de suivi disponible', 'Livraison contre signature', 14.00, null),
		(2, 'Colis standard', null, 'Livré sous 7 jours ouvrés, sans suivi', 8.00, null),
		(2, 'Chronopost', 'Livré sous 48h, suivi internet et sms', 'Livré en main propre contre signature', 18.70, null),
		(3, 'Express', 'Livré le lendemain avant 18h', 'Livré en main propre contre signature', 20.00, null),
		(3, 'Prioritaire', 'Livré sous 4 jours ouvrés, suivi internet', 'Livraison en boîte aux lettres', 5.00, null),
		(4, 'Lettre ordinaire', '1 à 2 semaines', 'Livré en boîte aux lettres', 3.50, 'aucun suivi, aucune garantie')
;

insert into ASSOC_STATUS_CARRIER 
	(CARRIER_STATUS_ID, CARRIER_ID, ASSOC_STATUS_CARRIER_DATE, ASSOC_STATUS_CARRIER_POST_IT)
	values 
		(1, 1, '2012-12-2', 'contrat signé le 14/1/2012'),
		(2, 2, '2016-11-3', 'contrat signé le 8/3/2016, virement le 15 tous les mois'),
		(3, 3, '2014-7-15', 'plusieurs colis perdus, à surveiller'),
		(4, 4, '2015-7-3', null)		
;

insert into ASSOC_STATUS_PACKAGE 
	(PACKAGE_STATUS_ID, PACKAGE_ID, ASSOC_STATUS_PACKAGE_DATE, ASSOC_STATUS_PACKAGE_POST_IT)
	values
		('1', '1', '2018-12-12', null),
		('5', '2', '2020-7-12', null),
		('2', '3', '2020-7-6', null),
		('4', '6', '2018-11-7', null),
		('2', '7', '2019-1-11', null),
		('5', '8', '2020-2-14', null),
		('2', '9', '2019-9-26', null),
		('3', '4', '2013-12-13', null),
		('5', '4', '2019-12-2', 'ras'),
		('3', '2', '2017-2-20', null),
		('5', '3', '2020-8-31', null),
		('2', '4', '2020-2-29', null),
		('5', '5', '2014-3-18', null),
		('2', '6', '2019-5-24', null),
		('5', '7', '2018-6-18', null),
		('4', '8', '2019-11-9', null)
;

INSERT INTO ASSOC_CUSTOMER_BILLING_ADDRESS
	([CUSTOMER_ID],[ADDRESS_ID])
	VALUES
		(1,1),
		(2,2),
		(3,3),
		(4,4),
		(5,5),
		(6,6),
		(7,7),
		(8,8)
;

INSERT INTO ASSOC_CUSTOMER_DELIVERY_ADDRESS
	([CUSTOMER_ID],[ADDRESS_ID])
	VALUES
		(1, 1),
		(2, 2),
		(3, 3),
		(4, 4),
		(5, 5),
		(6, 6),
		(7, 7),
		(8, 8)
;

insert into ASSOC_ADDRESS_PUBLISHER 
	(PUBLISHER_ID, ADDRESS_ID)
	values 
		(1, 3),
		(2, 7),
		(3, 8)
;

insert into ATTRIBUTE 
	(ATTRIBUTE_KEY, ATTRIBUTE_VALUE)
	values 
		('url facebook', 'www.facebook.com/bookshop'),
		('url twitter', 'www.twitter.com/bookshop'),
		('url instagram', 'www.instagram.com/fr/bookshop')
;

insert into PERMISSION (PERMISSION_ID, PERMISSION_NAME) values (1, 'admin');
insert into PERMISSION (PERMISSION_ID, PERMISSION_NAME) values (2, 'user');
insert into PERMISSION (PERMISSION_ID, PERMISSION_NAME) values (3, 'intern');


insert into [dbo].[GROUP] (GROUP_ID, GROUP_NAME) values (1, 'admin');
insert into [dbo].[GROUP] (GROUP_ID, GROUP_NAME) values (2, 'user');
insert into [dbo].[GROUP] (GROUP_ID, GROUP_NAME) values (3, 'intern');


insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('admin', 'admin', '2019/01/10', '2020-12-10');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('user', 'user', '2019/01/10', '2020-12-10');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('intern', 'intern', '2019/01/10', '2020-12-10');														 
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('sa', 'sa', '2019/01/10', '2020-12-10');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('WilburtEmerton', 'CJIvKxuno', '2020-01-10', '2020-12-10');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('AnthiathiaMcGiven', 'k6gkQl', '2019-01-10', '2019-05-10');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('VincentyWorlock', 'IXZ6IbKeNqN', '2019-12-16', '2021-12-16');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('AlanahWrangle', 'HvWVEYdFHZi', '2020-4-26', '2024-04-30');
insert into EMPLOYEE (EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END) values ('BabbetteTwatt', '5XHmJzWSM', '2019-5-12', '2020-11-30');

--OK COMMENT STATUS
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('Synergistic', 'Down-sized interactive projection');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('upward-trending', 'Fully-configurable cohesive encoding');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('mobile', 'Cross-group analyzing portal');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('Optimized', 'Self-enabling hybrid groupware');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('User-friendly', 'Secured composite hierarchy');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('full-range', 'Cross-platform even-keeled knowledge base');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('conglomeration', 'Stand-alone eco-centric help-desk');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('multimedia', 'Devolved holistic secured line');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('frame', 'Programmable scalable matrix');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('firmware', 'Profit-focused mobile moratorium');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('User-centric', 'Quality-focused global workforce');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('optimal', 'Profit-focused exuding database');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('alliance', 'Streamlined reciprocal approach');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('infrastructure', 'Upgradable leading edge groupware');
insert into COMMENT_STATUS (COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT) values ('Reactive', 'Enhanced scalable product');

insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (2,'organisemePaiement1');
insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (5,'organisemePaiement2');
insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (10,'organisemePaiement3');
insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (9,'organisemePaiement4');
insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (7,'organisemePaiement5');
insert into PAYMENT_ORGANIZATION (ADDRESS_ID,PAYMENT_ORGANIZATION_NAME) values (3,'organisemePaiement6');

insert into CARD_TYPE (PAYMENT_ORGANIZATION_ID,CARD_TYPE_NAME,CARD_TYPE_LOGO_URL) values (1,'mastercard','url1');
insert into CARD_TYPE (PAYMENT_ORGANIZATION_ID,CARD_TYPE_NAME,CARD_TYPE_LOGO_URL) values (2,'visaelectron','url2');
insert into CARD_TYPE (PAYMENT_ORGANIZATION_ID,CARD_TYPE_NAME,CARD_TYPE_LOGO_URL) values (3,'electron','url3');
insert into CARD_TYPE (PAYMENT_ORGANIZATION_ID,CARD_TYPE_NAME,CARD_TYPE_LOGO_URL) values (4,'visa','url4');
insert into CARD_TYPE (PAYMENT_ORGANIZATION_ID,CARD_TYPE_NAME,CARD_TYPE_LOGO_URL) values (5,'premium','url5');

insert into ORDER_STATUS values (1,'validee','commande prise en compte');
insert into ORDER_STATUS values (2,'en cours','commande en cour de preparation');
insert into ORDER_STATUS values (3,'annuléé','commande annulee par client');
insert into ORDER_STATUS values (4,'annulee','rupture de stock');
insert into ORDER_STATUS values (5,'terminee','commande livree');
insert into ORDER_STATUS values (6,'expediee','commande expediee');

-- ID's start at 1 for both: 
insert into ASSOC_GROUP_EMPLOYEE (EMPLOYEE_ID, GROUP_ID) values (1, 1)
insert into ASSOC_GROUP_EMPLOYEE (EMPLOYEE_ID, GROUP_ID) values (2, 3)
insert into ASSOC_GROUP_EMPLOYEE (EMPLOYEE_ID, GROUP_ID) values (3, 1)
insert into ASSOC_GROUP_EMPLOYEE (EMPLOYEE_ID, GROUP_ID) values (4, 2)
insert into ASSOC_GROUP_EMPLOYEE (EMPLOYEE_ID, GROUP_ID) values (5, 3)

-- OK, but run last!
insert into ASSOC_PERMISSION_GROUP (PERMISSION_ID, GROUP_ID) values (1, 1)
insert into ASSOC_PERMISSION_GROUP (PERMISSION_ID, GROUP_ID) values (2, 2)
insert into ASSOC_PERMISSION_GROUP (PERMISSION_ID, GROUP_ID) values (3, 3)

INSERT INTO [dbo].[ORDER]
	([CUSTOMER_ID],[DELIVERY_ADDRESS_ID],[BILLING_ADDRESS_ID],[SHIPPING_OFFER_ID],[ORDER_CREATION_DATE],[ORDER_SHIPPING_TIME_LIMIT],
	[ORDER_USER_IP],[ORDER_COMMENT],[ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE])
     VALUES
           (1, 1, 1, 5, '2019/01/10', 9 ,'0.255.255.255','lacus.',6.0),
		   (2, 2, 3, 5, '2019/01/10',9,'0.255.255.255','justo sit amet',9.8),
		   (4, 3, 4, 6, '2020-09-21 00:29:07',12,'0.255.255.255','montes, nascetur ridiculus mus. Aenean',1.6),
		   (5, 4, 5, 2, '2020-09-08 20:43:10',10, '0.255.255.255','massa. Mauris vestibulum, neque sed dictum',4.0)
;

insert into PAYMENT_STATUS (PAYMENT_STATUS_NAME,PAYMENT_STATUS_POST_IT) values ('valide','commentairePaiement 1');
insert into PAYMENT_STATUS (PAYMENT_STATUS_NAME,PAYMENT_STATUS_POST_IT) values ('refuse','commentairePaiement 2');
insert into PAYMENT_STATUS (PAYMENT_STATUS_NAME,PAYMENT_STATUS_POST_IT) values ('en cours de traitement','commentairePaiement 3');
insert into PAYMENT_STATUS (PAYMENT_STATUS_NAME,PAYMENT_STATUS_POST_IT) values ('en attente de validation','commentairePaiement 4');
insert into PAYMENT_STATUS (PAYMENT_STATUS_NAME,PAYMENT_STATUS_POST_IT) values ('en cour de verfication','commentairePaiement 5');

INSERT INTO PAYMENT
	(PAYMENT_SUB_ID, ORDER_ID, CARD_TYPE_ID, ASSOC_PAYMENT_ORDER_DATE, ASSOC_PAYMENT_ORDER_POST_IT)
	VALUES
		('er5zer886zer', 1, 2, '2020-09-08 20:43:10', 'commentaire_0'),
		('zer9865qsf89', 2, 3, '2020-09-08 20:43:10', 'commentaire_1'),
		('45r9865qsf89', 2, 1, '2020-09-08 20:43:10', 'commentaire_2'),
		('98r9800qsf89', 2, 3, '2020-09-08 20:43:10', 'commentaire_3')
;

INSERT INTO ASSOC_STATUS_PAYMENT
	(PAYMENT_ID, PAYMENT_SUB_ID, PAYMENT_STATUS_ID, ASSOC_STATUS_PAYMENT_DATE, ASSOC_STATUS_PAYMENT_POST_IT)
	VALUES
		(1, 'er5zer886zer', 1, '2020-09-08 20:43:10', null),
		(2, 'zer9865qsf89', 1, '2020-09-08 20:43:10', null),
		(3, '45r9865qsf89', 2, '2020-09-08 20:43:10', null),
		(4, '98r9800qsf89', 4, '2020-09-08 20:43:10', null)
;

insert into ASSOC_ORDER_PACKAGE (ORDER_ID,PACKAGE_ID) values (1,2);
insert into ASSOC_ORDER_PACKAGE (ORDER_ID,PACKAGE_ID) values (2,3);
insert into ASSOC_ORDER_PACKAGE (ORDER_ID,PACKAGE_ID) values (3,1);
insert into ASSOC_ORDER_PACKAGE (ORDER_ID,PACKAGE_ID) values (4,2);
insert into ASSOC_ORDER_PACKAGE (ORDER_ID,PACKAGE_ID) values (3,4);

insert into ASSOC_STATUS_ORDER (ORDER_ID,ORDER_STATUS_ID,ASSOC_STATUS_ORDER_DATE,ASSOC_STATUS_ORDER_POST_IT) values (1,2,'2020-08-31T12:00:00','commentaireStatut1');
insert into ASSOC_STATUS_ORDER (ORDER_ID,ORDER_STATUS_ID,ASSOC_STATUS_ORDER_DATE,ASSOC_STATUS_ORDER_POST_IT) values (2,3,'2020-07-27T13:30:00','commentaireStatut1');
insert into ASSOC_STATUS_ORDER (ORDER_ID,ORDER_STATUS_ID,ASSOC_STATUS_ORDER_DATE,ASSOC_STATUS_ORDER_POST_IT) values (3,4,'2020-06-03T15:00:40','commentaireStatut1');
insert into ASSOC_STATUS_ORDER (ORDER_ID,ORDER_STATUS_ID,ASSOC_STATUS_ORDER_DATE,ASSOC_STATUS_ORDER_POST_IT) values (4,6,'2020-08-14T09:20:15','commentaireStatut1');
insert into ASSOC_STATUS_ORDER (ORDER_ID,ORDER_STATUS_ID,ASSOC_STATUS_ORDER_DATE,ASSOC_STATUS_ORDER_POST_IT) values (1,1,'2020-09-01T19:01:00','commentaireStatut1');

insert into ORDER_ROW (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE) values (null, 1, '9782203001107', 1, '11.33', '44.01');
insert into ORDER_ROW (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE) values (null, 2, '9782080706881', 2, '12.07', '9.38');
insert into ORDER_ROW (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE) values (null, 3, '9782080706881', 3, '10.18', '27.35');
insert into ORDER_ROW (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE) values (null, 4, '9782080706881', 4, '2.49', '31.16');
insert into ORDER_ROW (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE) values (null, 4, '9782203001107', 5, '13.20', '30.55');

insert into COMMENT (CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING, COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE) values (1, 1, '9782203001107', 'forecast', 1, 'engineer 24/7 models', '2020-02-25T12:39:02', '127.46.205.152', '2020-02-14T05:32:46');
insert into COMMENT (CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING, COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE) values (2, 2, '9782080706881', 'Ergonomic', 2, 'generate B2C applications', '2020-06-30T06:06:19', '253.125.33.249', '2020-01-24T21:50:09');
insert into COMMENT (CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING, COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE) values (3, 3, '9782080706881', 'structure', 3, 'optimize bricks-and-clicks synergies', '2019-09-18T18:26:26', '228.209.107.216', '2020-05-23T20:15:36');
insert into COMMENT (CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING, COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE) values (4, 4, '9782080706881', 'local', 4, 'innovate customized initiatives', '2020-02-26T07:12:53', '151.228.148.194', '2019-09-14T12:00:04');
insert into COMMENT (CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING, COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE) values (5, 5, '9782203001107', 'interactive', 5, 'seize synergistic networks', '2020-03-11T03:15:40', '175.61.123.249', '2020-02-17T13:57:57');

insert into ASSOC_COMMENT_EMPLOYEE 
	(EMPLOYEE_ID, COMMENT_ID, ASSOC_COMMENT_EMPLOYEE_DATE, ASSOC_COMMENT_EMPLOYEE_POST_IT)
	values
		(1, 1, '2020-09-01T19:01:00', 'sans commentaire'),
		(1, 2, '2020-09-01T19:01:00', 'sans commentaire'),
		(2, 3, '2020-09-01T19:01:00', 'sans commentaire'),
		(4, 4, '2020-09-01T19:01:00', 'sans commentaire')
;

insert into ASSOC_STATUS_COMMENT 
	(COMMENT_ID, COMMENT_STATUS_ID, ASSOC_STATUS_COMMENT_DATE, ASSOC_STATUS_COMMENT_POST_IT)
	values
		(1, 1, '2020-09-01T19:01:00', 'sans commentaire'),
		(2, 2, '2020-09-01T19:01:00', 'sans commentaire'),
		(3, 3, '2020-09-01T19:01:00', 'sans commentaire'),
		(4, 4, '2020-09-01T19:01:00', 'sans commentaire')
;

-- TESTDATA END --
SELECT 'SCRIPT OK' FROM ATTRIBUTE;