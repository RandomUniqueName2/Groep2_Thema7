CREATE OR REPLACE TRIGGER BRG_TRIGGER_${table.name}
    BEFORE DELETE OR INSERT OR UPDATE
    ON ${table.name}
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
    
    ${body}
    
    IF l_errors IS NOT NULL
    THEN
        RAISE APPLICATION_ERROR(-20800, l_errors);
    END IF;
END;