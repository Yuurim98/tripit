-- 사용자
INSERT INTO user_entity (id, email, name, nickname, password, phone_number)
VALUES (1, 'hong@example.com', '홍길동', '길동이', '1234', '010-1234-5678'),
       (2, 'kim@example.com', '김영희', '영희짱', '1234', '010-5678-1234'),
       (3, 'park@example.com', '박철수', '철수짱', '1234', '010-0000-1111');

-- 여행
INSERT INTO trips_entity (id, area_code, end, name, start, user_id)
VALUES (1, 1, '2025-05-05', '서울 벚꽃 여행', '2025-05-03', 1),
       (2, 2, '2025-06-15', '부산 먹방 투어', '2025-06-12', 2);

-- 일정
INSERT INTO itineraries_entity (id, date, day_number, trips_id)
VALUES (1, '2025-05-03', 1, 1),
       (2, '2025-05-04', 2, 1),
       (3, '2025-06-12', 1, 2);

-- 활동
INSERT INTO activities_entity (id, content_id, end, start, itineraries_id)
VALUES (1, '101', '2025-05-03 14:00:00', '2025-05-03 10:00:00', 1),
       (2, '102', '2025-05-04 12:00:00', '2025-05-04 09:00:00', 2),
       (3, '103', '2025-06-12 18:00:00', '2025-06-12 13:00:00', 3);

-- 모집글
INSERT INTO meetup_post_entity (id, content, personnel, title, view_count, trips_id, user_id)
VALUES (1, '같이 벚꽃 보러 가실 분~ 편하게 와주세요!', 5, '서울 벚꽃 같이 보러가요!', 10, 1, 1),
       (2, '부산에서 맛집 위주로 다닐 거예요! 관심 있는 분 환영~', 3, '부산 먹방 투어 모집', 5, 2, 2);

-- 모임
INSERT INTO meetup_entity (id, status, host_id, post_id)
VALUES (1, 'OPEN', 1, 1),
       (2, 'OPEN', 2, 2);

-- 신청
INSERT INTO meetup_applications_entity (id, content, status, meetup_id, user_id)
VALUES (1, '벚꽃 너무 좋아해서 신청합니다!', 'PENDING', 1, 2),
       (2, '맛집 마니아입니다. 같이 가고 싶어요!', 'APPROVED', 2, 3);

-- 참여자
INSERT INTO participants_entity (id, meetup_id, user_id)
VALUES (1, 2, 3);
