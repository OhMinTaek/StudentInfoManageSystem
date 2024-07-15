import React, { useState, useEffect } from 'react';
import '../css/StudentModal.css'; // 추가 스타일 파일

const StudentModal = ({ student, onSave, onDelete, onClose }) => {
    const [formData, setFormData] = useState({
        id: null,
        name: '',
        district: '',
        school: '',
        major: '',
    });

    useEffect(() => {
        if (student) {
            setFormData(student);
        } else {
            setFormData({ id: null, name: '', district: '', school: '', major: '' });
        }
    }, [student]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onSave(formData);
        setFormData({ id: null, name: '', district: '', school: '', major: '' }); // 폼 초기화
    };

    return (
        <div className="modal-overlay">
            <div className="modal-content">
                <h2>{student ? '학생 정보 수정' : '학생 추가'}</h2>
                <form onSubmit={handleSubmit}>
                    <input
                        name="name"
                        placeholder="이름"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                    <input
                        name="district"
                        placeholder="거주하는 동"
                        value={formData.district}
                        onChange={handleChange}
                    />
                    <input
                        name="school"
                        placeholder="학교"
                        value={formData.school}
                        onChange={handleChange}
                    />
                    <input
                        name="major"
                        placeholder="전공"
                        value={formData.major}
                        onChange={handleChange}
                    />
                    <button type="submit">저장</button>
                    {student && <button type="button" onClick={() => onDelete(student.id)}>삭제</button>}
                </form>
                <button onClick={onClose}>닫기</button>
            </div>
        </div>
    );
};

export default StudentModal;
