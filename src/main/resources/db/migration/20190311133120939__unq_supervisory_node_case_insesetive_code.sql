CREATE UNIQUE INDEX unq_supervisory_node_case_insesetive_code
ON supervisory_nodes(LOWER(code))