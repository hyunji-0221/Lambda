-- 001. 전체 축구팀 목록을 팀 이름 오름차순으로 출력하시오.
select team_name from team
order by team_name asc; -- ASC(오름차순) 생략 가능

-- 002. 플레이어의 포지션 종류를 나열하시오. 단, 중복은 제거하고 포지션이 없으면 빈공간으로 두시오.
select distinct position
from player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
select distinct
case
when position = '' then '신입' else position
end
from player;

select distinct ifnull(nullif(position,''),'신입') from player;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다
select player_name
from player
where team_id = 'K02' and position = 'GK';

-- 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 모름.
select player_name
from player p
    left join team t
    on p.team_id = t.team_id
where t.region_name = '수원' and p.position = 'GK';

select player_name
from player
where position = 'GK' and team_id = (select team_id
                                        from team
                                        where region_name='수원');

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다
select player_name
from player
where team_id = 'K02' and player_name like '고%' and height >=170;

-- 005-1. 수원팀에서 성이 고씨, 키가 170이상 선수를 출력. 단 수원팀의 ID는 모름.
select player_name
from player p
    left join team t
    on p.team_id = t.team_id
where t.region_name = '수원' and p.player_name like '고%' and p.height>=170;

select player_name
from player
where player_name like '고%' and height >=170 and team_id = (select team_id
                                                             from team
                                                             where region_name = '수원');

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오 -> player.player_name
-- 소속팀이 삼성블루윙즈이거나 -> team.team_name k02
-- 드래곤즈에 소속된 선수들이어야 하고, -> team.team_name k07
-- 포지션이 미드필더(MF:Midfielder)이어야 한다. player.position
-- 키는 170 센티미터 이상이고 180 이하여야 한다. player.height
select player_name
from player p
where position = 'MF'
and (height between 170 and 180)
and team_id in (select team_id
                from team
                where team_name = '삼성블루윙즈' or team_name = '드래곤즈');
-- ---------------- 다시 ----------------

-- 문제 7
-- 수원을 연고지로 하는 골키퍼는 누구인가?
select player_name
from player
where position = 'GK' and team_id = (select team_id
                 from team
                 where region_name = '수원');

-- 문제 8
-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name,
ifnull(nullif(height,''),'0') as height,
ifnull(nullif(weight,''),'0') as weight
from player
where team_id = (select team_id
                 from team
                 where region_name = '서울')
order by weight desc, height desc;


-- 문제 9
-- 서울팀 선수들 이름과 포지션과
-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름 내림차순으로 정렬하시오
select player_name, position,
concat(ifnull(nullif(height,''),'0'),'cm') as height,
concat(ifnull(nullif(weight,''),'0'),'kg') as weight,
(case when (height/((weight/100)*(weight/100)))>=25 then '비만'
     when (height/((weight/100)*(weight/100)))>=23 then '과체중'
     when (height/((weight/100)*(weight/100)))>=18.5 then '정상'
     else '저체중'
end) as bmi
from player
where team_id = (select team_id
                 from team
                 where region_name='서울')
order by player_name desc;