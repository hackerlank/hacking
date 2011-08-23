drop table revsinmr;

--create table mrsfiles (
--   	mrid char (60),
--   	filename char (140),
--	revisionid char(40),
--	daterev    date,
--	timerev    time,
--	primary key (mrid, filename, revisionid),
--	foreign key (filename,revisionid) references revisions,
--	foreign key (FILENAME) references files,
--	foreign key (mrid) references mrs2
--);
--
create table revsinmr(
	mrid varchar(60) NOT NULL,
	filename varchar(140) NOT NULL,
	revid    varchar(40) NOT NULL,
	primary key (mrid, filename, revid),
	foreign key (filename,revid) references revisions,
	foreign key (filename) references files,
	foreign key (mrid) references mrs
);

