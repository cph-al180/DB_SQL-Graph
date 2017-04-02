
create table t_user (
 node_id int PRIMARY KEY, 
 name varchar(255) not null,
 job varchar(255) not null,
 birthday date not null
);

CREATE UNIQUE INDEX t_user_node_id_uindex ON t_user (node_id);

create table t_endorsements (
source_node_id int not null,
target_node_id int not null,
PRIMARY KEY (source_node_id, target_node_id),
FOREIGN KEY (source_node_id) REFERENCES t_user (node_id),
FOREIGN KEY (target_node_id) REFERENCES t_user (node_id)
);

LOAD DATA INFILE 'D:/archive_graph/social_network_nodes.csv'
INTO TABLE sqlandgraph.t_user
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(node_id,name,job,birthday);

LOAD DATA INFILE 'D:/archive_graph/social_network_edges.csv'
INTO TABLE sqlandgraph.t_endorsements
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(source_node_id,target_node_id);


