select user
from dual;
--==>> scott

select *
from tbl_memberlist;
--==>> tbl_memberlist �ִ� ����� ���� �ϱ�

CREATE TABLE TBL_MEMBERLIST
( ID    VARCHAR2(30)    NOT NULL
, PW    VARCHAR2(50)    NOT NULL
, NAME  VARCHAR2(50)    NOT NULL
, TEL   VARCHAR2(50)    NOT NULL
, EMAIL VARCHAR2(100)
, CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(ID)
);
--==>> Table TBL_MEMBERLIST��(��) �����Ǿ����ϴ�.


--�� ������ �Է�(��ȣȭ ��Ű�� ���)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('admin', CRYPTPACK.ENCRYPT('java006$', 'admin'), '������', '010-1234-1234','admin@test.com');
--> ���� ����
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) VALUES('admin', CRYPTPACK.ENCRYPT('java006$', 'admin'), '������', '010-1234-1234','admin@test.com')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ŀ��
COMMIT;
-->> Ŀ�� �Ϸ�.


--�� �⺻ ��ȸ ������ ����
SELECT ID, NAME, TEL, EMAIL
FROM TBL_MEMBERLIST
ORDER BY ID;
--> ���� ����
SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST ORDER BY ID
;

--�� �������߰� �Է�(���� ���� �ǽ��� ���� �غ�)
INSERT INTO TBL_MEMBERLIST(ID,PW,NAME,TEL,EMAIL)
VALUES('djdjdj', CRYPTPACK.ENCRYPT('java006$','djdjdj'),'�մ���','010-6214-3742','chelll1@naver.com');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ŀ��
COMMIT;
-->> Ŀ�� �Ϸ�.
