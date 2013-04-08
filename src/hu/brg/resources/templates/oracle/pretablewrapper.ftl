CREATE OR REPLACE TRIGGER BRG_TRG_${tableHash}
    BEFORE DELETE OR INSERT OR UPDATE
    ON ${tableName}
    FOR EACH ROW
DECLARE
    l_oper   varchar2(3);
    l_errors varchar2(4000);
BEGIN
    IF INSERTING 
    THEN
        l_oper := 'INS';
    ELSIF UPDATING 
    THEN
        l_oper := 'UPD';
    ELSIF DELETING 
    THEN
        l_oper := 'DEL';
    END IF;