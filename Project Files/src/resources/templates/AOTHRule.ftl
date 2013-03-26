    -- Attribute Other Rule :: ${query}
    DECLARE
        l_passed boolean := false;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            ${query}
            
            IF NOT l_passed
            THEN 
                l_errors := l_errors || 'Violated query -> ${query}';
            END IF;
        END IF;
    END;